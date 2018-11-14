package com.example.demo.voice;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 语音工具.
 * 
 * @author caowenjun
 *
 */
public class VoiceTools {

	public static void main(String[] args) {
		String str = "单环芳烃只含一个苯环，如苯、甲苯、乙苯、二甲苯、异丙苯、十二烷基苯等。多环芳烃是由两个或两个以上苯环（苯环上没有两环共用的碳原子）组成的，它们之间是以单键或通过碳原子相联，如联苯、三苯甲烷等。稠环芳烃是由两个或两个以上的苯环通过稠合（使两个苯环共用一对碳原子）而成的稠环烃，其中至少一个是苯环，如萘、蒽等。芳烃中最重要的产品是苯、二甲苯，其次是甲苯、乙苯、苯乙烯、异丙苯。苯及其分子量较小的同系物是易燃液体，不溶于水，密度比水小；多环芳烃及稠环芳烃多是晶状固体。芳烃均有毒性，其中以苯对中枢神经及血液的作用最强。稠环芳烃有致癌作用。";
		String str1 = "相见时难别亦难，东风无力百花残。 春蚕到死丝方尽，蜡炬成灰泪始干。 晓镜但愁云鬓改，夜吟应觉月光寒。 蓬山此去多无路，青鸟殷勤为探看。";
		String str2 = "《红楼梦》，中国古代章回体长篇小说，又名《石头记》等，被列为中国古典四大名著之首，一般认为是清代作家曹雪芹所著。小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，描绘了一批举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美，可以说是一部从各个角度展现女性美的史诗。\r\n"
				+ "《红楼梦》版本可分为120回“程本”和80回“脂本”两大系统。程本为程伟元排印的印刷本，脂本为脂砚斋在不同时期抄评的早期手抄本。脂本是程本的底本。此书新版通行本前80回据脂本汇校，后40回据程本汇校，署名“曹雪芹著，无名氏续，程伟元、高鹗整理”。\r\n"
				+ "《红楼梦》是一部具有世界影响力的人情小说，举世公认的中国古典小说巅峰之作，中国封建社会的百科全书，传统文化的集大成者。小说以“大旨谈情，实录其事”自勉，只按自己的事体情理，按迹循踪，摆脱旧套，新鲜别致，取得了非凡的艺术成就。“真事隐去，假语村言”的特殊笔法更是令后世读者脑洞大开，揣测之说久而遂多。后世围绕《红楼梦》的品读研究形成了一门显学——红学。";
		VoiceTools.speak(str);
	}

	public static void speak(String str) {
		// 获取sapi
		ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
		Dispatch sapo = sap.getObject();
		try {
			// 音量 0-100
			sap.setProperty("Volume", new Variant(100));
			// 语音朗读速度 -10 到 +10
			sap.setProperty("Rate", new Variant(-1));

			Variant defalutVoice = sap.getProperty("Voice");

			Dispatch dispdefaultVoice = defalutVoice.toDispatch();
			Variant allVoices = Dispatch.call(sapo, "GetVoices");
			Dispatch dispVoices = allVoices.toDispatch();

			Dispatch setvoice = Dispatch.call(dispVoices, "Item", new Variant(1)).toDispatch();
			ActiveXComponent voiceActivex = new ActiveXComponent(dispdefaultVoice);
			ActiveXComponent setvoiceActivex = new ActiveXComponent(setvoice);

			Variant item = Dispatch.call(setvoiceActivex, "GetDescription");
			// 执行朗读
			Dispatch.call(sapo, "Speak", new Variant(str));

		} catch (Exception e) {
			System.out.println("语音播报出错");
		} finally {
			sapo.safeRelease();
			sap.safeRelease();
		}
	}
}
