(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["actors"],{"1ded":function(t,a,s){"use strict";s("58f9")},4229:function(t,a,s){"use strict";s("b5eb")},"58f9":function(t,a,s){},"8b44":function(t,a,s){"use strict";s.r(a);var e=function(){var t=this,a=t._self._c;return a("div",{attrs:{id:"main"}},[t._m(0),a("v-dialog"),a("router-link",{staticClass:"button is-primary",attrs:{to:"/actor",tag:"button"}},[t._v("Add Actor")]),a("div",{staticClass:"content"},[a("table",{staticClass:"table",attrs:{id:"actors"}},[t._m(1),a("tbody",t._l(t.actors,(function(s){return a("tr",{key:s.id},[a("td",[t._v(t._s(s.id))]),a("td",[t._v(t._s(s.firstName)+" "+t._s(s.lastName))]),a("td",[t._v(t._s(t.moment(s.dateOfBirth).utc().format("MM/DD/YYYY")))]),a("td",[a("a",{staticClass:"is-secondary",on:{click:function(a){return t.deleteActor(s.id)}}},[t._v(" Delete")]),a("router-link",{staticClass:"button is-secondary",attrs:{to:"/actor/"+s.id,tag:"button"}},[t._v("Edit Actor")])],1)])})),0)])])],1)},i=[function(){var t=this,a=t._self._c;return a("div",{staticClass:"header"},[a("h1",{staticClass:"title"},[t._v("Actors")])])},function(){var t=this,a=t._self._c;return a("thead",[a("tr",[a("th",[t._v("#")]),a("th",[t._v("Name")]),a("th",[t._v("Date of Birth")]),a("th")])])}],r={name:"Actors",data:()=>({actors:[]}),methods:{async deleteActor(t){try{await this.$http.delete("http://3.149.27.3:8080/api/actors/"+t),this.$modal.show("example");const{data:a}=await this.$http.get("http://3.149.27.3:8080/api/actors");this.actors=a}catch(a){this.$modal.show("dialog",{title:"Error",text:"Deleting Actor failed",buttons:[{title:"Ok",handler:()=>{this.$modal.hide("dialog")}}]})}}},async mounted(){console.log("actors mounted being");const{data:t}=await this.$http.get("http://3.149.27.3:8080/api/actors");console.log("actors mounted data",t),this.actors=t}},o=r,c=(s("4229"),s("2877")),d=Object(c["a"])(o,e,i,!1,null,"9a6ca9cc",null);a["default"]=d.exports},b5eb:function(t,a,s){},e4d5:function(t,a,s){"use strict";s.r(a);var e=function(){var t=this,a=t._self._c;return a("div",{attrs:{id:"main"}},[t._m(0),a("v-dialog"),a("router-link",{staticClass:"button is-primary",attrs:{to:"/director",tag:"button"}},[t._v("Add Director")]),a("div",{staticClass:"content"},[a("table",{staticClass:"table",attrs:{id:"directors"}},[t._m(1),a("tbody",t._l(t.directors,(function(s){return a("tr",{key:s.id},[a("td",[t._v(t._s(s.id))]),a("td",[t._v(t._s(s.firstName)+" "+t._s(s.lastName))]),a("td",[t._v(t._s(t.moment(s.dateOfBirth).utc().format("MM/DD/YYYY")))]),a("td",[a("a",{staticClass:"is-secondary",on:{click:function(a){return t.deleteDirector(s.id)}}},[t._v(" Delete")]),a("router-link",{staticClass:"button is-secondary",attrs:{to:"/director/"+s.id,tag:"button"}},[t._v("Edit")])],1)])})),0)])])],1)},i=[function(){var t=this,a=t._self._c;return a("div",{staticClass:"header"},[a("h1",{staticClass:"title"},[t._v("Directors")])])},function(){var t=this,a=t._self._c;return a("thead",[a("tr",[a("th",[t._v("#")]),a("th",[t._v("Name")]),a("th",[t._v("Date of Birth")]),a("th")])])}],r={name:"Directors",data:()=>({directors:[]}),methods:{async deleteDirector(t){try{await this.$http.delete("http://3.149.27.3:8080/api/directors/"+t);const{data:a}=await this.$http.get("http://3.149.27.3:8080/api/directors");this.directors=a}catch(a){this.$modal.show("dialog",{title:"Error",text:"Deleting Director failed",buttons:[{title:"Ok",handler:()=>{this.$modal.hide("dialog")}}]})}}},async mounted(){console.log("directors mounted being");const{data:t}=await this.$http.get("http://3.149.27.3:8080/api/directors");console.log("directors mounted data",t),this.directors=t}},o=r,c=(s("1ded"),s("2877")),d=Object(c["a"])(o,e,i,!1,null,"5f5ed1aa",null);a["default"]=d.exports}}]);
//# sourceMappingURL=actors.04aecc27.js.map