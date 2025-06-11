package com.item.study.modules.api;

import com.item.study.modules.network.OkResult;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 知识库接口
 * https://bigmodel.cn/dev/api#uploadfile
 */

public class Chat {

    public Chat() {}

    // 对话
    public static OkResult completion(String msg) {
//        ChatV4Body body = new ChatV4Body(new ChatV4Body.ListItem("user", msg));
//        OkResult<String> res = ChatSSERequest.post("/paas/v4/chat/completions", body);
//        if(res.code == 0) {
//            return OkResult.ok(ChatRequest.jsonToBean(res.data, ChatChoice.class));
//        }
        return null;
    }

    // 问题
    public static OkResult invoke(String id, String msg) {
//        PromptBody body = new PromptBody(new PromptBody.ListItem("user", msg));
//        OkResult<String> res = ChatSSERequest.post("/llm-application/open/model-api/"+id+"/invoke", body);
//        if(res.code == 0) {
//            return OkResult.ok(ChatRequest.jsonToBean(res.data, ListEntity.class));
//        }
        return null;
    }

    // 智能体
    public static OkResult assistant(String id, String fid, String msg) {
//        Assistant body = new Assistant(id, "", fid, msg);
////        System.out.println(body);
//        OkResult<String> res = ChatSSERequest.post("/paas/v4/assistant", body);
//        if(res.code == 0) {
//            return OkResult.ok(ChatRequest.jsonToBean(res.data, ListEntity.class));
//        }
        return null;
    }


    /**
     * 应用中心查询知识库
     * https://bigmodel.cn/api/llm-application/trialv2/knowledge_info
     */
    public OkResult knowledgeInfo() {

        return null;
    }
    /**
     * https://bigmodel.cn/api/llm-application/trialv2/generate_request_id
     * {"appId":"1776203731508060161","appReq":{"extraInput":"{\"knowledge_ids\":[\"1774346652367437824\"],\"document_ids\":[\"1774348212375896064\",\"1837732841753051136\",\"1837790619049816064\"]}"},"conversationId":526774,"histories":[{"content":"行政复议申请\n","role":"user"}]}
     * {
     *   "data": {
     *     "id": "hek_gOqT8XftFinwV1rwE"
     *   },
     *   "code": 200,
     *   "message": "请求成功",
     *   "timestamp": 1727314561533
     * }
     *
     *
     * https://bigmodel.cn/api/llm-application/trialv2/prompts
     * {"request_id":"hek_gOqT8XftFinwV1rwE"}
     * {
     *   "data": {
     *     "slices": "输入:\n从文档\n\"\"\"\n一、行政复议申请条件\n（一）有明确的申请人和符和行政复议法规定的被申请人；\n（二）申请人与被申请行政复议的行政行为有利害关系；\n（三）有具体的行政复议请求和理由；\n（四）在法定申请期限内提出；\n（五）属于行政复议法规定的行政复议范围；\n（六）属于本行政复议机关的管辖范围；\n（七）行政复议机关和人民法院未受理过申请人就同一行政行为提出的行政复议申请和行政诉讼。\n\n二、行政复议申请所需材料\n（一）行政复议申请书；\n（二）被申请人作出具体行政行为的证明材料，如行政处罚决定、投诉举报答复等（复印件，核对原件）；\n（三）申请人身份证（复印件，核对原件）；\n（四）委托他人办理的，还需提交：\n1、授权委托书（原件，委托人及被委托人双方签字）；\n2、被委托人的身份证（复印件，核对原件）；\n3、委托律师或者基层法律服务工作者代理的，须提交执业证和所在法律服务机构出具的委托代理函件。\n\n三、行政复议申请方式\n（一）现场申请\n申请人携带申请材料至区公共法律服务中心及各街镇行政复\n议咨询服务点现场申请；（二）网上申请\n1、申请人通过上海市司法局网站“法治政府”板块中的“行\n政复议服务”中的“行政复议网上申请”即可向市政府提交\n复议\n申请；\n2、申请人可关注“上海市司法局”微信公众号，在“服务”\n或底部菜单栏中选择“复议申请”直接申请；\n（三）邮寄申请\n行政复议邮寄地址：上海市徐汇区漕东支路 81 号 5 楼徐汇\n区\n行政复议局 邮编：200235（建议使用 EMS、挂号信等有凭证\n的邮\n寄方式， 信封上请注明“行政复议”字样，不接受同城快递\n方式\n邮寄）。\n\n徐汇区行政复议咨询服务点\n申请指南\n\n五、行政复议申请流程\n1. 当收到行政复议申请时，首先进行审查。\n2. 如果申请书及相关证明材料齐全，进入下一步；否则，要\n求申请人补充材料。\n3. 对于符合受理条件的申请，予以受理并发送副本给被申请\n人。\n4. 如果申请不属于本机关受理范围，指引申请人向其他相关\n机构提出。\n5. 对于不符合受理条件的申请，不予受理。\n6. 在符合受理条件的情况下，开始计时，通常在六十天内作\n出行政复议决定。\n7. 如果情况复杂，无法在规定期限内作出决定，可以适当延\n长，但最长不超过三十天。\n8. 案件受理后，根据案件类型和领域，选择合适的调解方式\n进行处理。\n9. 如果调解成功，申请人撤回复议申请，行政复议机构终止\n结案。\n10. 如果未能达成调解协议，行政复议机构将继续审理案件。行政复议的申请方式都有哪些?\n(一)现场申请申请人携带申请材料至区公共法律服务中心及各街镇行政复议咨询服务点现场申请； (二)网上申请 1、申请人通过上海市司法局网站“法治政府”板块中的“行政复议服务”中的“行政复议网上申请”即可向市政府提交复议申请；2、申请人可关注“上海市司法局”微信公众号，在“服务”或底部菜单栏中选择“复议申请”直接申请；\n行政复议的申请材料\n1.行政复议申请书\n2.被申请人作出具体行政行为的证明材料\n3.申请人身份证\n4.授权委托书\n\n五、行政复议申请流程\n7. 经审核，符合人民调解受理范围且双方愿意调解：如果经过审核，发现案件符合人民调解的受理范围，并且双方都愿意调解，那么将进入调解前的准备阶段。\n8. 调解前的准备：在正式组织调解之前，需要做好准备工作，包括告知双方当事人的权利和义务，以及确定调解方案。\n9. 组织调解（可多次）：根据准备情况，组织调解会议，这个过程可能需要多次进行。\n10. 达成协议：如果在调解过程中达成协议，那么将制作人民调解协议书（或达成口头协议）。\n11. 未达成协议：如果未能达成协议，将告知当事人可以通过其他途径解决纠纷。\n12. 申请司法确认或诉调对接（非必经程序）：如果达成协议，可以选择申请司法确认或诉调对接，但这不是必须的步骤。\n13. 调解协议履行与监督：达成协议后，需要确保协议得到履行，并进行监督。\n\n五、行政复议申请流程\n第二十四条 人民调解组织应当在当事人平等协商、互谅互让的基础上，提出矛盾纠纷化解\n（三）受援人利用法律援助从事违法活动；\n（四）受援人的经济状况发生变化，不再符合法律援助条件；\n（五）案件终止审理或者已经被撤销；\n（六）受援人自行委托律师或者其他代理人；\n（七）受援人有正当理由要求终止法律援助；\n\n五、行政复议申请流程\n14. 结案归档：最后，当整个调解过程结束时，需要结案并归档相关文件。\nQ：通过人民调解可以做到哪些事项?\nA：当事人通过人民调解达成一致并且签署人民调解协议的案件，人民调解委员会将协助办理司法确认、公证对接、诉调对接等业务。\nQ 哪些纠纷类型可以申请人民调解?\nA：常见的民事纠纷均可申请人民调解，如婚姻家庭纠纷、法定继承纠纷、合同纠纷、人身损害赔偿纠纷、住宅小区内的物业费纠纷、医患纠纷等。\nQ：一般情况下，人民调解期限是多久?\nA：人民调解委员会自案件受理之日起 30 个工作日内完成。因特殊情况确需延长调解期限的，人民调解委员会与当事人可以约定延长调解期限。超过调解期限未协商一致的，视为调解不成。\nQ：哪些情况下，人民调解委员会不予受理?\nA ：(1)一方当事人已向人民法院提起诉讼的，但人民法院委托调解除外； (2)一方当事人已向其他行政部门申请处理的，但行政部门终止处理的除外； (3)一方当事人拒绝调解的； (4)法律、法规规定只能由专门机关管辖处理的，或者法律、法规禁止采用调解方式解决的。\n小程序申请操作流程：\n1、用微信扫描右侧小程序码，进入到随申办首页；\n2、在随申办首页最上方搜索栏输入“解纷一件事”,点击搜索后进入该事项；\n\n\"\"\"\n中找问题\n\"\"\"\n行政复议申请\n\n\"\"\"\n的答案，找到答案就仅使用文档语句回答问题，找不到答案就用自身知识回答并且告诉用户该信息不是来自文档。\n\n不要复述问题，直接开始回答。"
     *   },
     *   "code": 200,
     *   "message": "请求成功",
     *   "timestamp": 1727314889197
     * }
     *
     * # pip install zhipuai 请先在终端进行安装
     *
     * zhipuai.api_key = "your api key" // baaa696e5a564afe5e4ce49236e852b0.dV3gTIO7SasX8K6H
     * response = zhipuai.model_api.sse_invoke(
     *     model="glm-3-turbo",
     *     prompt= [{"role":"user","content":"行政复议申请"}],
     *     temperature= 0.01,
     *     top_p= 0.1,
     *     incremental=False,
     * )
     *
     * for event in response.events():
     *     if event.event == "add":
     *         print(event.data)
     *     elif event.event == "error" or event.event == "interrupted":
     *         print(event.data)
     *     elif event.event == "finish":
     *         print(event.data)
     *         print(event.meta)
     *     else:
     *         print(event.data)
     *
     */
}
