"use strict";(self["webpackChunkvue_wizian"]=self["webpackChunkvue_wizian"]||[]).push([[925],{925:function(t,o,l){l.r(o),l.d(o,{default:function(){return f}});var e=l(641),n=l(33),a=l(3751);const s={class:"container"},c=(0,e.Lk)("h1",null,"정기상담 예약 조회",-1),k={class:"table regRev"},u=(0,e.Lk)("thead",null,[(0,e.Lk)("tr",null,[(0,e.Lk)("th",{scope:"col"},"번호"),(0,e.Lk)("th",{scope:"col"},"학번"),(0,e.Lk)("th",{scope:"col"},"상태")])],-1),h=["onClick"],r={scope:"row"},i=["onClick"],d=(0,e.Lk)("button",null,"거절",-1),p={class:"modal-wrap"},L={class:"modal-container"},g={key:0,class:"table stu"},C=(0,e.Lk)("thead",null,[(0,e.Lk)("tr",null,[(0,e.Lk)("th",{scope:"col"},"번호"),(0,e.Lk)("th",{scope:"col"},"학번"),(0,e.Lk)("th",{scope:"col"},"상태")])],-1),m={scope:"row"},b={class:"modal-btn"};function v(t,o,l,v,_,w){return(0,e.uX)(),(0,e.CE)("div",s,[c,(0,e.Lk)("table",k,[u,(0,e.Lk)("tbody",null,[((0,e.uX)(!0),(0,e.CE)(e.FK,null,(0,e.pI)(_.list,(t=>((0,e.uX)(),(0,e.CE)("tr",{key:t.reg_no,class:(0,n.C4)([t.reg_no+"tr"]),onClick:o=>w.modalOpen(t.reg_no)},[(0,e.Lk)("td",r,(0,n.v_)(t.reg_no),1),(0,e.Lk)("td",null,(0,n.v_)(t.stuNum),1),"0"===t.stat?((0,e.uX)(),(0,e.CE)("td",{key:0,class:(0,n.C4)([t.reg_no+"stat"])},[(0,e.Lk)("button",{onClick:o=>w.al(t,1)},"승인",8,i),d],2)):(0,e.Q3)("",!0),"1"===t.stat?((0,e.uX)(),(0,e.CE)("td",{key:1,class:(0,n.C4)([t.no+"stat"])},"승인완료",2)):(0,e.Q3)("",!0),(0,e.Lk)("td",null,[(0,e.Lk)("button",{onClick:o[0]||(o[0]=(...t)=>w.modalOpen&&w.modalOpen(...t))},"자세히보기")])],10,h)))),128))])]),(0,e.bo)((0,e.Lk)("div",p,[(0,e.Lk)("div",L,[(0,e.Lk)("button",{onClick:o[1]||(o[1]=(...t)=>w.btnPopup&&w.btnPopup(...t))},"신청하기"),t.responseData&&t.responseData.length>0?((0,e.uX)(),(0,e.CE)("table",g,[C,(0,e.Lk)("tbody",null,[(0,e.Lk)("tr",null,[(0,e.Lk)("th",m,(0,n.v_)(t.responseData[0].reg_no),1),(0,e.Lk)("th",null,(0,n.v_)(t.responseData[0].stuNum),1),(0,e.Lk)("th",null,(0,n.v_)(t.responseData[0].stat),1)])])])):(0,e.Q3)("",!0),(0,e.Lk)("div",b,[(0,e.Lk)("button",{onClick:o[2]||(o[2]=(...t)=>w.modalOpen&&w.modalOpen(...t))},"닫기")])])],512),[[a.aG,_.modalCheck]])])}var _=l(1250),w={data(){return{list:[],modalCheck:!1}},mounted(){_.A.get("http://localhost:3000/test").then((t=>{this.list=t.data.list}))},methods:{al(t,o){var l={reg_no:t.reg_no,stat:o};console.log("-------"),console.log(l),_.A.post("http://localhost:3000/accept",l).then((o=>{console.log(o),t.stat="1"})).catch((t=>{console.log(t)}))},async modalOpen(t){console.log(0==this.modalCheck),0==this.modalCheck&&await this.getData(t),this.modalCheck=!this.modalCheck,console.log(t)},btnPopup(){window.open("#/regTime","_blank","width=300,height=500")},async getData(t){try{const o=await _.A.get("http://localhost:3000/regDetail?rgno="+t);this.responseData=o.data,console.log(this.responseData)}catch(o){console.log("에러 발생: "+o)}}}},D=l(6262);const y=(0,D.A)(w,[["render",v]]);var f=y}}]);
//# sourceMappingURL=925.829f9744.js.map