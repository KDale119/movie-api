(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0a3c88"],{"043a":function(e,i,t){"use strict";t.r(i);var r=function(){var e=this,i=e._self._c;return i("div",[i("span",[e._v(e._s(e.movie.movieTitle))]),i("ul",[i("li",[e._v(e._s(e.movie.rating.rating))]),i("li",[e._v(e._s(e.movie.movieLength))]),i("li",[e._v(e._s(e.movie.genre.genre))]),i("li",[e._v(e._s(e.movie.releaseDate))]),i("li"),i("li",[e._v(e._s(e.movie.director.firstName)+" "+e._s(e.movie.director.lastName))]),i("li"),i("li",[i("h2",[e._v("Actors:")]),e._l(e.movie.actors,(function(t){return i("tr",{key:t.id},[i("td",[e._v(e._s(t.firstName))]),i("td",[e._v(e._s(t.lastName))]),i("td",[e._v(e._s(t.dateOfBirth))])])}))],2),i("li"),i("li",[i("sub",[e._v(e._s(e.movie.overview))])])]),i("iframe",{attrs:{width:"560",height:"315",src:e.movie.trailerUrl,frameborder:"0",allow:"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture",allowfullscreen:""}})])},a=[],s={data:()=>({movie:null}),async mounted(){const{data:e}=await this.$http.get("http://3.149.27.3:8080/api/movies/"+this.$route.params.id);this.movie=e}},o=s,l=t("2877"),v=Object(l["a"])(o,r,a,!1,null,null,null);i["default"]=v.exports}}]);
//# sourceMappingURL=chunk-2d0a3c88.194b96d9.js.map