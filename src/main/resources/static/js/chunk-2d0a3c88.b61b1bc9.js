(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0a3c88"],{"043a":function(t,e,i){"use strict";i.r(e);var r=function(){var t=this,e=t._self._c;return e("div",[e("span",[t._v(t._s(t.movie.movieTitle))]),e("ul",[e("li",[t._v(t._s(t.movie.rating.rating))]),e("li",[t._v(t._s(t.movie.movieLength))]),e("li",[t._v(t._s(t.movie.genre.genre))]),e("li",[t._v(t._s(t.movie.releaseDate))]),e("li"),e("li"),e("li",[e("strong",[t._v("Directed By: ")]),t._v(t._s(t.movie.director.firstName)+" "+t._s(t.movie.director.lastName))]),e("li"),e("li"),e("li",[e("strong",[t._v("Actors:")]),e("table",{staticClass:"table",attrs:{id:"actors"}},[t._m(0),e("tbody",t._l(t.movie.actors,(function(i){return e("tr",{key:i.id},[e("td",[t._v(t._s(i.firstName))]),e("td",[t._v(t._s(i.lastName))]),e("td",[t._v(t._s(i.dateOfBirth))])])})),0)])]),e("li"),e("li"),t._m(1),e("li",[e("sub",[t._v(t._s(t.movie.overview))])])]),e("iframe",{attrs:{width:"560",height:"315",src:t.movie.trailerUrl,frameborder:"0",allow:"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture",allowfullscreen:""}})])},a=[function(){var t=this,e=t._self._c;return e("thead",[e("tr",[e("th",[t._v("First Name")]),e("th",[t._v("Last Name")]),e("th",[t._v("Date of Birth")])])])},function(){var t=this,e=t._self._c;return e("li",[e("strong",[t._v("Overview:")])])}],s={data:()=>({movie:null}),async mounted(){const{data:t}=await this.$http.get("http://3.149.27.3:8080/api/movies/"+this.$route.params.id);this.movie=t}},o=s,l=i("2877"),v=Object(l["a"])(o,r,a,!1,null,null,null);e["default"]=v.exports}}]);
//# sourceMappingURL=chunk-2d0a3c88.b61b1bc9.js.map