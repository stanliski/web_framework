package com.jufengniao.framework.controller;

import java.awt.Color;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.patchca.color.ColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.filter.predefined.DiffuseRippleFilterFactory;
import org.patchca.filter.predefined.DoubleRippleFilterFactory;
import org.patchca.filter.predefined.MarbleRippleFilterFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.IOUtils;

/**
 * 
 * 验证码控制层
 * 
 * @author stanley
 *
 */
@Controller
@RequestMapping(value="/image")
public class CaptchaController {

	private static ConfigurableCaptchaService cs = new ConfigurableCaptchaService();

	private static Random random = new Random();
	
	private static Logger log =  Logger.getLogger(CaptchaController.class);

	static {
		cs.setColorFactory(new ColorFactory() {
			public Color getColor(int x) {
				int[] c = new int[3];
				int i = random.nextInt(c.length);
				for (int fi = 0; fi < c.length; fi++) {
					if (fi == i) {
						c[fi] = random.nextInt(71);
					} else {
						c[fi] = random.nextInt(256);
					}
				}
				return new Color(c[0], c[1], c[2]);
			}
		});
		RandomWordFactory wf = new RandomWordFactory();
		wf.setCharacters("23456789abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ");
		wf.setMaxLength(4);
		wf.setMinLength(4);
		cs.setWordFactory(wf);
	}

	@RequestMapping("/getKaptchaImage")
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ServletOutputStream out = response.getOutputStream();  
		try {  
			switch (random.nextInt(5)) {
			case 0:
				cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
				break;
			case 1:
				cs.setFilterFactory(new MarbleRippleFilterFactory());
				break;
			case 2:
				cs.setFilterFactory(new DoubleRippleFilterFactory());
				break;
			case 3:
				cs.setFilterFactory(new WobbleRippleFilterFactory());
				break;
			case 4:
				cs.setFilterFactory(new DiffuseRippleFilterFactory());
				break;
			}
			HttpSession session = request.getSession(false);
			if (session == null) {
				session = request.getSession();
			}
			setResponseHeaders(response);
			String token = EncoderHelper.getChallangeAndWriteImage(cs, "png", out);
			session.setAttribute("captchaToken", token);
			out.flush();  
		} finally {
			IOUtils.closeQuietly(out);
		}
		return null;
		
	}

	protected void setResponseHeaders(HttpServletResponse response) {
		response.setContentType("image/png");
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		long time = System.currentTimeMillis();
		response.setDateHeader("Last-Modified", time);
		response.setDateHeader("Date", time);
		response.setDateHeader("Expires", time);
	}

}
