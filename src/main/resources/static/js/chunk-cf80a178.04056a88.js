(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-cf80a178"],{"3e33":function(e,t,i){},c183:function(e,t,i){"use strict";i("3e33")},e883:function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e._self._c;return t("div",[t("h1",{staticClass:"title"},[e._v("Add Movie")]),t("div",{staticClass:"field"},[t("label",{staticClass:"label",attrs:{for:"movieTitle"}},[e._v("Movie Title")]),t("div",{staticClass:"control"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.movie.movieTitle,expression:"movie.movieTitle"}],staticClass:"input",attrs:{id:"movieTitle",type:"text",placeholder:"Movie Title"},domProps:{value:e.movie.movieTitle},on:{input:function(t){t.target.composing||e.$set(e.movie,"movieTitle",t.target.value)}}})])]),t("div",{staticClass:"field"},[t("label",{staticClass:"label",attrs:{for:"movieLength"}},[e._v("Movie Length")]),t("div",{staticClass:"control"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.movie.movieLength,expression:"movie.movieLength"}],staticClass:"input",attrs:{id:"movieLength",type:"number",placeholder:"Movie Length"},domProps:{value:e.movie.movieLength},on:{input:function(t){t.target.composing||e.$set(e.movie,"movieLength",t.target.value)}}})])]),t("div",{staticClass:"field"},[t("label",{staticClass:"label",attrs:{for:"releaseDate"}},[e._v("Release Date")]),t("div",{staticClass:"control"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.movie.releaseDate,expression:"movie.releaseDate"}],staticClass:"input",attrs:{id:"releaseDate",type:"date"},domProps:{value:e.movie.releaseDate},on:{input:function(t){t.target.composing||e.$set(e.movie,"releaseDate",t.target.value)}}})])]),t("div",{staticClass:"field"},[t("label",{staticClass:"label",attrs:{for:"trailerUrl"}},[e._v("Trailer Url")]),t("div",{staticClass:"control"},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.movie.trailerUrl,expression:"movie.trailerUrl"}],staticClass:"input",attrs:{id:"trailerUrl",type:"text",placeholder:"Trailer Url"},domProps:{value:e.movie.trailerUrl},on:{input:function(t){t.target.composing||e.$set(e.movie,"trailerUrl",t.target.value)}}})])]),t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[e._v("Director")]),t("div",{staticClass:"select"},[t("select",{directives:[{name:"model",rawName:"v-model",value:e.movie.director.id,expression:"movie.director.id"}],on:{change:function(t){var i=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.$set(e.movie.director,"id",t.target.multiple?i:i[0])}}},e._l(e.directors,(function(i){return t("option",{key:i.id,domProps:{value:i.id}},[e._v(" "+e._s(i.firstName)+" "+e._s(i.lastName)+" ")])})),0)])]),t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[e._v("Genre")]),t("div",{staticClass:"select"},[t("select",{directives:[{name:"model",rawName:"v-model",value:e.movie.genre.id,expression:"movie.genre.id"}],on:{change:function(t){var i=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.$set(e.movie.genre,"id",t.target.multiple?i:i[0])}}},e._l(e.genres,(function(i){return t("option",{key:i.id,domProps:{value:i.id}},[e._v(" "+e._s(i.genre)+" ")])})),0)])]),t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[e._v("Rating")]),e._l(e.ratings,(function(i){return t("span",{key:i.id,staticClass:"control"},[t("label",{staticClass:"radio",attrs:{for:"rating-"+i.id}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.movie.rating.id,expression:"movie.rating.id"}],staticClass:"radio",attrs:{type:"radio",id:"rating-"+i.id},domProps:{value:i.id,checked:e._q(e.movie.rating.id,i.id)},on:{change:function(t){return e.$set(e.movie.rating,"id",i.id)}}}),e._v(" "+e._s(i.rating)+" ")])])}))],2),t("div",{staticClass:"field"},[t("label",{staticClass:"label"},[e._v("Actors")]),e._l(e.actors,(function(i){return t("div",{key:i.id,staticClass:"control"},[t("label",{staticClass:"checkbox",attrs:{for:"actor-"+i.id}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.movie.actors,expression:"movie.actors"}],staticClass:"checkbox",attrs:{type:"checkbox",id:"actor-"+i.id},domProps:{value:i,checked:Array.isArray(e.movie.actors)?e._i(e.movie.actors,i)>-1:e.movie.actors},on:{change:function(t){var a=e.movie.actors,s=t.target,o=!!s.checked;if(Array.isArray(a)){var r=i,l=e._i(a,r);s.checked?l<0&&e.$set(e.movie,"actors",a.concat([r])):l>-1&&e.$set(e.movie,"actors",a.slice(0,l).concat(a.slice(l+1)))}else e.$set(e.movie,"actors",o)}}}),e._v(" "+e._s(i.firstName)+" "+e._s(i.lastName)+" ")])])}))],2),t("div",{staticClass:"field is-grouped"},[t("div",{staticClass:"control"},[t("button",{staticClass:"button",on:{click:e.cancel}},[e._v("Cancel")])]),t("div",{staticClass:"control"},[t("button",{staticClass:"button is-primary",on:{click:e.save}},[e._v("Save")])])])])},s=[],o=(i("14d9"),{data:()=>({movie:{movieTitle:null,movieLength:null,releaseDate:null,trailerUrl:null,director:{},genre:{},rating:{},actors:[]},directors:[],genres:[],ratings:[],actors:[]}),methods:{async save(){console.log("AddMovie.save() movie=",this.movie);const e=await this.$http.post("http://3.149.27.3:8080/api/movies/",this.movie);console.log("AddMovie.save() response=",e),200===e.status&&this.$router.push({path:"/movies"})},cancel(){this.$router.push({path:"/movies"})},async getDirectors(){const{data:e}=await this.$http.get("http://3.149.27.3:8080/api/directors");return console.log("getDirectors() data",e),e},async getGenres(){const{data:e}=await this.$http.get("http://3.149.27.3:8080/api/genres");return console.log("getGenres() data",e),e},async getRatings(){const{data:e}=await this.$http.get("http://3.149.27.3:8080/api/ratings");return console.log("getRatings() data",e),e},async getActors(){const{data:e}=await this.$http.get("http://3.149.27.3:8080/api/actors");return console.log("getActors() data",e),e}},async mounted(){this.directors=await this.getDirectors(),this.genres=await this.getGenres(),this.ratings=await this.getRatings(),this.actors=await this.getActors()}}),r=o,l=(i("c183"),i("2877")),n=Object(l["a"])(r,a,s,!1,null,"7f076de9",null);t["default"]=n.exports}}]);
//# sourceMappingURL=chunk-cf80a178.04056a88.js.map