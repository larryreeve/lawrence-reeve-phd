(function(){var $wnd = window;var $doc = $wnd.document;var $moduleName, $moduleBase;var _,EB='client.',FB='client.service.',aC='com.google.gwt.core.client.',bC='com.google.gwt.lang.',cC='com.google.gwt.user.client.',dC='com.google.gwt.user.client.impl.',eC='com.google.gwt.user.client.rpc.',fC='com.google.gwt.user.client.rpc.core.java.lang.',gC='com.google.gwt.user.client.rpc.core.java.util.',hC='com.google.gwt.user.client.rpc.impl.',iC='com.google.gwt.user.client.ui.',jC='com.google.gwt.user.client.ui.impl.',kC='java.lang.',lC='java.util.';function DB(){}
function ov(a){return this===a;}
function pv(){return sw(this);}
function mv(){}
_=mv.prototype={};_.eQ=ov;_.hC=pv;_.tN=kC+'Object';_.tI=1;function s(){}
_=s.prototype=new mv();_.tN=EB+'Sentence';_.tI=3;_.a=0.0;_.b=0;_.c=0;_.d='';function w(b,a){C(a,b.qb());D(a,b.rb());E(a,b.rb());F(a,b.tb());}
function x(a){return a.a;}
function y(a){return a.b;}
function z(a){return a.c;}
function A(a){return a.d;}
function B(b,a){b.Cb(x(a));b.Db(y(a));b.Db(z(a));b.Fb(A(a));}
function C(a,b){a.a=b;}
function D(a,b){a.b=b;}
function E(a,b){a.c=b;}
function F(a,b){a.d=b;}
function vb(r){var a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q;c=Bp(new zp(),'Input text to be summarized:');g=pr(new or());rr(g,80);sr(g,25);a=fn(new Fm(),'Summarize');o=Bp(new zp(),'Summary Size (% of original):');p=fq(new Fp());for(b=1;b<=100;b++)hq(p,wu(b));qq(p,false);rq(p,1);pq(p,9,true);d=fp(new dp());gp(d,a);gp(d,o);gp(d,p);on(d,o,(xo(),zo));on(d,p,(xo(),zo));hs(d,'95%');e=ps(new ns());qs(e,c);qs(e,g);qs(e,d);j=Bp(new zp(),'System-generated Summary:');l=pr(new or());rr(l,80);sr(l,25);zr(l,true);n=no(new mo());k=ps(new ns());qs(k,j);qs(k,l);qs(k,n);f=oo(new mo(),'<br><br><br>This summarizer implements the frequency distribution summarization algorithm (using terms rather than concepts) described in these papers:<br><br>Lawrence H. Reeve, Hyoil Han, Saya V. Nagori, Jonathan C. Yang, Tamara A. Schwimmer, and Ari D. Brooks (2006).<br><EM><A href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2006CIKM.pdf">Concept Frequency Distribution in Biomedical Text Summarization<\/A>.<\/EM><br><A href="http://sa1.sice.umkc.edu/cikm2006/"> <FONT face="Times New Roman">Proceedings of the 15th Conference on Information and Knowledge Management<\/FONT><\/A><FONT face="Times New Roman"><\/FONT><A href="http://www.cs.iupui.edu/%7Ebioin/"><\/A>.<br><br>Lawrence H. Reeve and Hyoil Han (2007).<br><EM><a href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2007DUC.pdf">A Term Frequency Distribution Approach for the DUC-2007 Update Task.<\/a><\/EM><br>Proceedings of the 2007 Document Understanding Conference Workshop (DUC 2007)<br><br>');m=fp(new dp());gp(m,f);h=fp(new dp());gp(h,e);gp(h,k);Eh(r);Bm(er(),h);Bm(er(),m);r.b=Eb(new yb());q=r.b;i=xc()+'summarizerservice';bc(q,i);r.a=cb(new bb(),r,l,n,a);zg(new gb());ei(),di();vr(g,new jb());wr(g,nb(new mb(),r,l));a.k(rb(new qb(),r,a,l,n,g,p));}
function wb(b,a){}
function ab(){}
_=ab.prototype=new mv();_.pb=wb;_.tN=EB+'TFDSSummarizer';_.tI=4;_.a=null;_.b=null;function cb(b,a,d,e,c){b.b=d;b.c=e;b.a=c;return b;}
function eb(b,a){qo(b.c,'Server Response:\n\n'+a.a);io(b.a,true);}
function fb(g,c){var a,b,d,e,f;f=Bd(c,2);b=wv(new vv());for(a=0;a<f.Bb();a++){d=Bd(f.D(a),3);if(d.c==0){e=d.d;if(e!==null&&dw(e)!=0){yv(b,d.d);yv(b,'\n\n');}}else{yv(b,'['+d.c+']: '+d.d);yv(b,'\n\n');}}Ar(g.b,Cv(b));Dp(g.c,'');io(g.a,true);}
function bb(){}
_=bb.prototype=new mv();_.tN=EB+'TFDSSummarizer$1';_.tI=0;function ib(){ei(),di();}
function gb(){}
_=gb.prototype=new mv();_.w=ib;_.tN=EB+'TFDSSummarizer$2';_.tI=5;function lb(a){}
function jb(){}
_=jb.prototype=new mv();_.fb=lb;_.tN=EB+'TFDSSummarizer$3';_.tI=6;function np(c,a,b){}
function op(c,a,b){}
function pp(c,a,b){}
function lp(){}
_=lp.prototype=new mv();_.ib=np;_.jb=op;_.kb=pp;_.tN=iC+'KeyboardListenerAdapter';_.tI=7;function nb(b,a,c){b.a=c;return b;}
function pb(d,a,b){var c;c=yr(this.a);if(c!==null&&dw(c)>0)Ar(this.a,'');}
function mb(){}
_=mb.prototype=new lp();_.jb=pb;_.tN=EB+'TFDSSummarizer$4';_.tI=8;function rb(b,a,c,e,f,d,g){b.a=a;b.b=c;b.d=e;b.e=f;b.c=d;b.f=g;return b;}
function tb(a){io(this.b,false);Ar(this.d,'');qo(this.e,'<b><i>Please wait...summarizing the source text.<\/i><\/b>');cc(this.a.b,yr(this.c),xu(mq(this.f,lq(this.f))),this.a.a);}
function qb(){}
_=qb.prototype=new mv();_.gb=tb;_.tN=EB+'TFDSSummarizer$5';_.tI=9;function ac(){ac=DB;dc=fc(new ec());}
function Eb(a){ac();return a;}
function Fb(d,b,c,a){if(d.a===null)throw lk(new kk());km(b);nl(b,'client.service.ISummarizerService');nl(b,'summarizeTFDS');ll(b,2);nl(b,'java.lang.String');nl(b,'java.lang.Integer');nl(b,c);ml(b,a);}
function bc(b,a){b.a=a;}
function cc(j,i,f,c){var a,d,e,g,h;g=xl(new wl(),dc);h=gm(new em(),dc,xc(),'AF8D9E63B5457AB80016BBD0E4B3C585');try{Fb(j,h,i,f);}catch(a){a=fe(a);if(Cd(a,4)){d=a;eb(c,d);return;}else throw a;}e=Ab(new zb(),j,g,c);if(!gh(j.a,nm(h),e))eb(c,ck(new bk(),'Unable to initiate the asynchronous service invocation -- check the network connection'));}
function yb(){}
_=yb.prototype=new mv();_.tN=FB+'ISummarizerService_Proxy';_.tI=0;_.a=null;var dc;function Ab(b,a,d,c){b.b=d;b.a=c;return b;}
function Cb(g,e){var a,c,d,f;f=null;c=null;try{if(ew(e,'//OK')){Al(g.b,fw(e,4));f=gl(g.b);}else if(ew(e,'//EX')){Al(g.b,fw(e,4));c=Bd(gl(g.b),5);}else{c=ck(new bk(),e);}}catch(a){a=fe(a);if(Cd(a,4)){a;c=Bj(new Aj());}else if(Cd(a,5)){d=a;c=d;}else throw a;}if(c===null)fb(g.a,f);else eb(g.a,c);}
function Db(a){var b;b=zc;Cb(this,a);}
function zb(){}
_=zb.prototype=new mv();_.hb=Db;_.tN=FB+'ISummarizerService_Proxy$1';_.tI=0;function gc(){gc=DB;rc=lc();tc=mc();}
function fc(a){gc();return a;}
function hc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[1](c,a);}
function ic(b,c){var a=tc[c];return a==null?c:a;}
function jc(c,b,d){var a=rc[d];if(!a){sc(d);}return a[0](b);}
function kc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[2](c,a);}
function lc(){gc();return {'client.Sentence/1365443775':[function(a){return nc(a);},function(a,b){w(a,b);},function(a,b){B(a,b);}],'com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533':[function(a){return oc(a);},function(a,b){Fj(a,b);},function(a,b){ak(a,b);}],'java.lang.Integer/3438268394':[function(a){return rk(a);},function(a,b){qk(a,b);},function(a,b){sk(a,b);}],'java.lang.String/2004016611':[function(a){return wk(a);},function(a,b){vk(a,b);},function(a,b){xk(a,b);}],'java.util.ArrayList/3821976829':[function(a){return pc(a);},function(a,b){Ak(a,b);},function(a,b){Bk(a,b);}],'java.util.Vector/3125574444':[function(a){return qc(a);},function(a,b){Ek(a,b);},function(a,b){Fk(a,b);}]};}
function mc(){gc();return {'client.Sentence':'1365443775','com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException':'3936916533','java.lang.Integer':'3438268394','java.lang.String':'2004016611','java.util.ArrayList':'3821976829','java.util.Vector':'3125574444'};}
function nc(a){gc();return new s();}
function oc(a){gc();return Bj(new Aj());}
function pc(a){gc();return Ey(new Cy());}
function qc(a){gc();return sB(new rB());}
function sc(a){gc();throw gk(new fk(),a);}
function ec(){}
_=ec.prototype=new mv();_.tN=FB+'ISummarizerService_TypeSerializer';_.tI=0;var rc,tc;function xc(){return Ec();}
function yc(a){return a==null?null:a.tN;}
var zc=null;function Cc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Dc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Ec(){return $moduleBase;}
function Fc(){return ++ad;}
var ad=0;function uw(b,a){b.a=a;return b;}
function vw(c,b,a){c.a=b;return c;}
function tw(){}
_=tw.prototype=new mv();_.tN=kC+'Throwable';_.tI=10;_.a=null;function du(b,a){uw(b,a);return b;}
function eu(c,b,a){vw(c,b,a);return c;}
function cu(){}
_=cu.prototype=new tw();_.tN=kC+'Exception';_.tI=11;function rv(b,a){du(b,a);return b;}
function sv(c,b,a){eu(c,b,a);return c;}
function qv(){}
_=qv.prototype=new cu();_.tN=kC+'RuntimeException';_.tI=12;function cd(c,b,a){rv(c,'JavaScript '+b+' exception: '+a);return c;}
function bd(){}
_=bd.prototype=new qv();_.tN=aC+'JavaScriptException';_.tI=13;function gd(b,a){if(!Cd(a,6)){return false;}return ld(b,Bd(a,6));}
function hd(a){return Cc(a);}
function id(){return [];}
function jd(){return function(){};}
function kd(){return {};}
function md(a){return gd(this,a);}
function ld(a,b){return a===b;}
function nd(){return hd(this);}
function ed(){}
_=ed.prototype=new mv();_.eQ=md;_.hC=nd;_.tN=aC+'JavaScriptObject';_.tI=14;function pd(c,a,d,b,e){c.a=a;c.b=b;c.tN=e;c.tI=d;return c;}
function rd(a,b,c){return a[b]=c;}
function sd(b,a){return b[a];}
function td(a){return a.length;}
function vd(e,d,c,b,a){return ud(e,d,c,b,0,td(b),a);}
function ud(j,i,g,c,e,a,b){var d,f,h;if((f=sd(c,e))<0){throw new Cu();}h=pd(new od(),f,sd(i,e),sd(g,e),j);++e;if(e<a){j=fw(j,1);for(d=0;d<f;++d){rd(h,d,ud(j,i,g,c,e,a,b));}}else{for(d=0;d<f;++d){rd(h,d,b);}}return h;}
function wd(a,b,c){if(c!==null&&a.b!=0&& !Cd(c,a.b)){throw new yt();}return rd(a,b,c);}
function od(){}
_=od.prototype=new mv();_.tN=bC+'Array';_.tI=0;function zd(b,a){return !(!(b&&be[b][a]));}
function Ad(a){return String.fromCharCode(a);}
function Bd(b,a){if(b!=null)zd(b.tI,a)||ae();return b;}
function Cd(b,a){return b!=null&&zd(b.tI,a);}
function Dd(a){return a&65535;}
function Ed(a){return ~(~a);}
function ae(){throw new Et();}
function Fd(a){if(a!==null){throw new Et();}return a;}
function ce(b,d){_=d.prototype;if(b&& !(b.tI>=_.tI)){var c=b.toString;for(var a in _){b[a]=_[a];}b.toString=c;}return b;}
var be;function fe(a){if(Cd(a,5)){return a;}return cd(new bd(),he(a),ge(a));}
function ge(a){return a.message;}
function he(a){return a.name;}
function je(b,a){return b;}
function ie(){}
_=ie.prototype=new qv();_.tN=cC+'CommandCanceledException';_.tI=15;function af(a){a.a=ne(new me(),a);a.b=Ey(new Cy());a.d=re(new qe(),a);a.f=ve(new ue(),a);}
function bf(a){af(a);return a;}
function df(c){var a,b,d;a=xe(c.f);Ae(c.f);b=null;if(Cd(a,7)){b=je(new ie(),Bd(a,7));}else{}if(b!==null){d=zc;}gf(c,false);ff(c);}
function ef(e,d){var a,b,c,f;f=false;try{gf(e,true);Be(e.f,e.b.b);sh(e.a,10000);while(ye(e.f)){b=ze(e.f);c=true;try{if(b===null){return;}if(Cd(b,7)){a=Bd(b,7);a.w();}else{}}finally{f=Ce(e.f);if(f){return;}if(c){Ae(e.f);}}if(kf(rw(),d)){return;}}}finally{if(!f){ph(e.a);gf(e,false);ff(e);}}}
function ff(a){if(!iz(a.b)&& !a.e&& !a.c){hf(a,true);sh(a.d,1);}}
function gf(b,a){b.c=a;}
function hf(b,a){b.e=a;}
function jf(b,a){az(b.b,a);ff(b);}
function kf(a,b){return Au(a-b)>=100;}
function le(){}
_=le.prototype=new mv();_.tN=cC+'CommandExecutor';_.tI=0;_.c=false;_.e=false;function qh(){qh=DB;yh=Ey(new Cy());{xh();}}
function oh(a){qh();return a;}
function ph(a){if(a.b){th(a.c);}else{uh(a.c);}kz(yh,a);}
function rh(a){if(!a.b){kz(yh,a);}a.xb();}
function sh(b,a){if(a<=0){throw hu(new gu(),'must be positive');}ph(b);b.b=false;b.c=vh(b,a);az(yh,b);}
function th(a){qh();$wnd.clearInterval(a);}
function uh(a){qh();$wnd.clearTimeout(a);}
function vh(b,a){qh();return $wnd.setTimeout(function(){b.x();},a);}
function wh(){var a;a=zc;{rh(this);}}
function xh(){qh();Dh(new kh());}
function jh(){}
_=jh.prototype=new mv();_.x=wh;_.tN=cC+'Timer';_.tI=16;_.b=false;_.c=0;var yh;function oe(){oe=DB;qh();}
function ne(b,a){oe();b.a=a;oh(b);return b;}
function pe(){if(!this.a.c){return;}df(this.a);}
function me(){}
_=me.prototype=new jh();_.xb=pe;_.tN=cC+'CommandExecutor$1';_.tI=17;function se(){se=DB;qh();}
function re(b,a){se();b.a=a;oh(b);return b;}
function te(){hf(this.a,false);ef(this.a,rw());}
function qe(){}
_=qe.prototype=new jh();_.xb=te;_.tN=cC+'CommandExecutor$2';_.tI=18;function ve(b,a){b.d=a;return b;}
function xe(a){return fz(a.d.b,a.b);}
function ye(a){return a.c<a.a;}
function ze(b){var a;b.b=b.c;a=fz(b.d.b,b.c++);if(b.c>=b.a){b.c=0;}return a;}
function Ae(a){jz(a.d.b,a.b);--a.a;if(a.b<=a.c){if(--a.c<0){a.c=0;}}a.b=(-1);}
function Be(b,a){b.a=a;}
function Ce(a){return a.b==(-1);}
function De(){return ye(this);}
function Ee(){return ze(this);}
function Fe(){Ae(this);}
function ue(){}
_=ue.prototype=new mv();_.F=De;_.cb=Ee;_.ub=Fe;_.tN=cC+'CommandExecutor$CircularIterator';_.tI=0;_.a=0;_.b=(-1);_.c=0;function nf(){nf=DB;mg=Ey(new Cy());{hg=new li();pi(hg);}}
function of(b,a){nf();yi(hg,b,a);}
function pf(a,b){nf();return ni(hg,a,b);}
function qf(){nf();return Ai(hg,'button');}
function rf(){nf();return Ai(hg,'div');}
function sf(a){nf();return Bi(hg,a);}
function tf(){nf();return Ai(hg,'tbody');}
function uf(){nf();return Ai(hg,'td');}
function vf(){nf();return Ai(hg,'tr');}
function wf(){nf();return Ai(hg,'table');}
function xf(){nf();return Ai(hg,'textarea');}
function Af(b,a,d){nf();var c;c=zc;{zf(b,a,d);}}
function zf(b,a,c){nf();var d;if(a===lg){if(bg(b)==8192){lg=null;}}d=yf;yf=b;try{c.eb(b);}finally{yf=d;}}
function Bf(b,a){nf();Ci(hg,b,a);}
function Cf(a){nf();return Di(hg,a);}
function Df(a){nf();return Ei(hg,a);}
function Ef(a){nf();return Fi(hg,a);}
function Ff(a){nf();return aj(hg,a);}
function ag(a){nf();return bj(hg,a);}
function bg(a){nf();return cj(hg,a);}
function cg(a){nf();ui(hg,a);}
function eg(a,b){nf();return ej(hg,a,b);}
function dg(a,b){nf();return dj(hg,a,b);}
function fg(a){nf();return fj(hg,a);}
function gg(a){nf();return vi(hg,a);}
function ig(c,b,d,a){nf();gj(hg,c,b,d,a);}
function jg(a){nf();var b,c;c=true;if(mg.b>0){b=Fd(fz(mg,mg.b-1));if(!(c=null.bc())){Bf(a,true);cg(a);}}return c;}
function kg(b,a){nf();hj(hg,b,a);}
function pg(a,b,c){nf();kj(hg,a,b,c);}
function ng(a,b,c){nf();ij(hg,a,b,c);}
function og(a,b,c){nf();jj(hg,a,b,c);}
function qg(a,b){nf();lj(hg,a,b);}
function rg(a,b){nf();mj(hg,a,b);}
function sg(a,b){nf();nj(hg,a,b);}
function tg(b,a,c){nf();oj(hg,b,a,c);}
function ug(a,b){nf();ri(hg,a,b);}
function vg(){nf();return pj(hg);}
function wg(){nf();return qj(hg);}
var yf=null,hg=null,lg=null,mg;function yg(){yg=DB;Ag=bf(new le());}
function zg(a){yg();if(a===null){throw Fu(new Eu(),'cmd can not be null');}jf(Ag,a);}
var Ag;function Dg(a){if(Cd(a,8)){return pf(this,Bd(a,8));}return gd(ce(this,Bg),a);}
function Eg(){return hd(ce(this,Bg));}
function Bg(){}
_=Bg.prototype=new ed();_.eQ=Dg;_.hC=Eg;_.tN=cC+'Element';_.tI=19;function ch(a){return gd(ce(this,Fg),a);}
function dh(){return hd(ce(this,Fg));}
function Fg(){}
_=Fg.prototype=new ed();_.eQ=ch;_.hC=dh;_.tN=cC+'Event';_.tI=20;function fh(){fh=DB;hh=sj(new rj());}
function gh(c,b,a){fh();return uj(hh,c,b,a);}
var hh;function mh(){while((qh(),yh).b>0){ph(Bd(fz((qh(),yh),0),9));}}
function nh(){return null;}
function kh(){}
_=kh.prototype=new mv();_.nb=mh;_.ob=nh;_.tN=cC+'Timer$1';_.tI=21;function Ch(){Ch=DB;Fh=Ey(new Cy());ji=Ey(new Cy());{fi();}}
function Dh(a){Ch();az(Fh,a);}
function Eh(a){Ch();az(ji,a);}
function ai(){Ch();var a,b;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);b.nb();}}
function bi(){Ch();var a,b,c,d;d=null;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);c=b.ob();{d=c;}}return d;}
function ci(){Ch();var a,b;for(a=ji.ab();a.F();){b=Bd(a.cb(),11);b.pb(ei(),di());}}
function di(){Ch();return vg();}
function ei(){Ch();return wg();}
function fi(){Ch();__gwt_initHandlers(function(){ii();},function(){return hi();},function(){gi();$wnd.onresize=null;$wnd.onbeforeclose=null;$wnd.onclose=null;});}
function gi(){Ch();var a;a=zc;{ai();}}
function hi(){Ch();var a;a=zc;{return bi();}}
function ii(){Ch();var a;a=zc;{ci();}}
var Fh,ji;function yi(c,b,a){b.appendChild(a);}
function Ai(b,a){return $doc.createElement(a);}
function Bi(c,a){var b;b=Ai(c,'select');if(a){ij(c,b,'multiple',true);}return b;}
function Ci(c,b,a){b.cancelBubble=a;}
function Di(b,a){return !(!a.altKey);}
function Ei(b,a){return !(!a.ctrlKey);}
function Fi(b,a){return a.which||(a.keyCode|| -1);}
function aj(b,a){return !(!a.metaKey);}
function bj(b,a){return !(!a.shiftKey);}
function cj(b,a){switch(a.type){case 'blur':return 4096;case 'change':return 1024;case 'click':return 1;case 'dblclick':return 2;case 'focus':return 2048;case 'keydown':return 128;case 'keypress':return 256;case 'keyup':return 512;case 'load':return 32768;case 'losecapture':return 8192;case 'mousedown':return 4;case 'mousemove':return 64;case 'mouseout':return 32;case 'mouseover':return 16;case 'mouseup':return 8;case 'scroll':return 16384;case 'error':return 65536;case 'mousewheel':return 131072;case 'DOMMouseScroll':return 131072;}}
function ej(d,a,b){var c=a[b];return c==null?null:String(c);}
function dj(d,a,c){var b=parseInt(a[c]);if(!b){return 0;}return b;}
function fj(b,a){return a.__eventBits||0;}
function gj(e,d,b,f,a){var c=new Option(b,f);if(a== -1||a>d.options.length-1){d.add(c,null);}else{d.add(c,d.options[a]);}}
function hj(c,b,a){b.removeChild(a);}
function kj(c,a,b,d){a[b]=d;}
function ij(c,a,b,d){a[b]=d;}
function jj(c,a,b,d){a[b]=d;}
function lj(c,a,b){a.__listener=b;}
function mj(c,a,b){if(!b){b='';}a.innerHTML=b;}
function nj(c,a,b){while(a.firstChild){a.removeChild(a.firstChild);}if(b!=null){a.appendChild($doc.createTextNode(b));}}
function oj(c,b,a,d){b.style[a]=d;}
function pj(a){return $doc.body.clientHeight;}
function qj(a){return $doc.body.clientWidth;}
function ki(){}
_=ki.prototype=new mv();_.tN=dC+'DOMImpl';_.tI=0;function ui(b,a){a.preventDefault();}
function vi(c,a){var b=a.parentNode;if(b==null){return null;}if(b.nodeType!=1)b=null;return b||null;}
function wi(d){$wnd.__dispatchCapturedMouseEvent=function(b){if($wnd.__dispatchCapturedEvent(b)){var a=$wnd.__captureElem;if(a&&a.__listener){Af(b,a,a.__listener);b.stopPropagation();}}};$wnd.__dispatchCapturedEvent=function(a){if(!jg(a)){a.stopPropagation();a.preventDefault();return false;}return true;};$wnd.addEventListener('click',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('dblclick',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousedown',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mouseup',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousemove',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousewheel',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('keydown',$wnd.__dispatchCapturedEvent,true);$wnd.addEventListener('keyup',$wnd.__dispatchCapturedEvent,true);$wnd.addEventListener('keypress',$wnd.__dispatchCapturedEvent,true);$wnd.__dispatchEvent=function(b){var c,a=this;while(a&& !(c=a.__listener))a=a.parentNode;if(a&&a.nodeType!=1)a=null;if(c)Af(b,a,c);};$wnd.__captureElem=null;}
function xi(c,b,a){b.__eventBits=a;b.onclick=a&1?$wnd.__dispatchEvent:null;b.ondblclick=a&2?$wnd.__dispatchEvent:null;b.onmousedown=a&4?$wnd.__dispatchEvent:null;b.onmouseup=a&8?$wnd.__dispatchEvent:null;b.onmouseover=a&16?$wnd.__dispatchEvent:null;b.onmouseout=a&32?$wnd.__dispatchEvent:null;b.onmousemove=a&64?$wnd.__dispatchEvent:null;b.onkeydown=a&128?$wnd.__dispatchEvent:null;b.onkeypress=a&256?$wnd.__dispatchEvent:null;b.onkeyup=a&512?$wnd.__dispatchEvent:null;b.onchange=a&1024?$wnd.__dispatchEvent:null;b.onfocus=a&2048?$wnd.__dispatchEvent:null;b.onblur=a&4096?$wnd.__dispatchEvent:null;b.onlosecapture=a&8192?$wnd.__dispatchEvent:null;b.onscroll=a&16384?$wnd.__dispatchEvent:null;b.onload=a&32768?$wnd.__dispatchEvent:null;b.onerror=a&65536?$wnd.__dispatchEvent:null;b.onmousewheel=a&131072?$wnd.__dispatchEvent:null;}
function si(){}
_=si.prototype=new ki();_.tN=dC+'DOMImplStandard';_.tI=0;function ni(c,a,b){if(!a&& !b){return true;}else if(!a|| !b){return false;}return a.isSameNode(b);}
function pi(a){wi(a);oi(a);}
function oi(d){$wnd.addEventListener('mouseout',function(b){var a=$wnd.__captureElem;if(a&& !b.relatedTarget){if('html'==b.target.tagName.toLowerCase()){var c=$doc.createEvent('MouseEvents');c.initMouseEvent('mouseup',true,true,$wnd,0,b.screenX,b.screenY,b.clientX,b.clientY,b.ctrlKey,b.altKey,b.shiftKey,b.metaKey,b.button,null);a.dispatchEvent(c);}}},true);$wnd.addEventListener('DOMMouseScroll',$wnd.__dispatchCapturedMouseEvent,true);}
function ri(c,b,a){xi(c,b,a);qi(c,b,a);}
function qi(c,b,a){if(a&131072){b.addEventListener('DOMMouseScroll',$wnd.__dispatchEvent,false);}}
function li(){}
_=li.prototype=new si();_.tN=dC+'DOMImplMozilla';_.tI=0;function sj(a){yj=jd();return a;}
function uj(c,d,b,a){return vj(c,null,null,d,b,a);}
function vj(d,f,c,e,b,a){return tj(d,f,c,e,b,a);}
function tj(e,g,d,f,c,b){var h=e.t();try{h.open('POST',f,true);h.setRequestHeader('Content-Type','text/plain; charset=utf-8');h.onreadystatechange=function(){if(h.readyState==4){h.onreadystatechange=yj;b.hb(h.responseText||'');}};h.send(c);return true;}catch(a){h.onreadystatechange=yj;return false;}}
function xj(){return new XMLHttpRequest();}
function rj(){}
_=rj.prototype=new mv();_.t=xj;_.tN=dC+'HTTPRequestImpl';_.tI=0;var yj=null;function Bj(a){rv(a,'This application is out of date, please click the refresh button on your browser');return a;}
function Aj(){}
_=Aj.prototype=new qv();_.tN=eC+'IncompatibleRemoteServiceException';_.tI=22;function Fj(b,a){}
function ak(b,a){}
function ck(b,a){sv(b,a,null);return b;}
function bk(){}
_=bk.prototype=new qv();_.tN=eC+'InvocationException';_.tI=23;function gk(b,a){du(b,a);return b;}
function fk(){}
_=fk.prototype=new cu();_.tN=eC+'SerializationException';_.tI=24;function lk(a){ck(a,'Service implementation URL not specified');return a;}
function kk(){}
_=kk.prototype=new bk();_.tN=eC+'ServiceDefTarget$NoServiceEntryPointSpecifiedException';_.tI=25;function qk(b,a){}
function rk(a){return qu(new pu(),a.rb());}
function sk(b,a){b.Db(a.a);}
function vk(b,a){}
function wk(a){return a.tb();}
function xk(b,a){b.Fb(a);}
function Ak(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();az(b,c);}}
function Bk(e,a){var b,c,d;d=a.b;e.Db(d);b=a.ab();while(b.F()){c=b.cb();e.Eb(c);}}
function Ek(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();tB(b,c);}}
function Fk(e,a){var b,c,d;d=a.a.b;e.Db(d);b=vB(a);while(b.F()){c=b.cb();e.Eb(c);}}
function tl(a){return a.j>2;}
function ul(b,a){b.i=a;}
function vl(a,b){a.j=b;}
function al(){}
_=al.prototype=new mv();_.tN=hC+'AbstractSerializationStream';_.tI=0;_.i=0;_.j=3;function cl(a){a.e=Ey(new Cy());}
function dl(a){cl(a);return a;}
function fl(b,a){cz(b.e);vl(b,Bl(b));ul(b,Bl(b));}
function gl(a){var b,c;b=a.rb();if(b<0){return fz(a.e,-(b+1));}c=a.B(b);if(c===null){return null;}return a.r(c);}
function hl(b,a){az(b.e,a);}
function il(){return gl(this);}
function bl(){}
_=bl.prototype=new al();_.sb=il;_.tN=hC+'AbstractSerializationStreamReader';_.tI=0;function ll(b,a){b.o(ow(a));}
function ml(c,a){var b,d;if(a===null){nl(c,null);return;}b=c.y(a);if(b>=0){ll(c,-(b+1));return;}c.yb(a);d=c.A(a);nl(c,d);c.zb(a,d);}
function nl(a,b){ll(a,a.l(b));}
function ol(a){this.o(nw(a));}
function pl(a){ll(this,a);}
function ql(a){ml(this,a);}
function rl(a){nl(this,a);}
function jl(){}
_=jl.prototype=new al();_.Cb=ol;_.Db=pl;_.Eb=ql;_.Fb=rl;_.tN=hC+'AbstractSerializationStreamWriter';_.tI=0;function xl(b,a){dl(b);b.c=a;return b;}
function zl(b,a){if(!a){return null;}return b.d[a-1];}
function Al(b,a){b.b=El(a);b.a=Fl(b.b);fl(b,a);b.d=Cl(b);}
function Bl(a){return a.b[--a.a];}
function Cl(a){return a.b[--a.a];}
function Dl(b){var a;a=jc(this.c,this,b);hl(this,a);hc(this.c,this,a,b);return a;}
function El(a){return eval(a);}
function Fl(a){return a.length;}
function am(a){return zl(this,a);}
function bm(){return this.b[--this.a];}
function cm(){return Bl(this);}
function dm(){return zl(this,Bl(this));}
function wl(){}
_=wl.prototype=new bl();_.r=Dl;_.B=am;_.qb=bm;_.rb=cm;_.tb=dm;_.tN=hC+'ClientSerializationStreamReader';_.tI=0;_.a=0;_.b=null;_.c=null;_.d=null;function fm(a){a.h=Ey(new Cy());}
function gm(d,c,a,b){fm(d);d.f=c;d.b=a;d.e=b;return d;}
function im(c,a){var b=c.d[a];return b==null?-1:b;}
function jm(c,a){var b=c.g[':'+a];return b==null?0:b;}
function km(a){a.c=0;a.d=kd();a.g=kd();cz(a.h);a.a=wv(new vv());if(tl(a)){nl(a,a.b);nl(a,a.e);}}
function lm(b,a,c){b.d[a]=c;}
function mm(b,a,c){b.g[':'+a]=c;}
function nm(b){var a;a=wv(new vv());om(b,a);qm(b,a);pm(b,a);return Cv(a);}
function om(b,a){sm(a,ow(b.j));sm(a,ow(b.i));}
function pm(b,a){yv(a,Cv(b.a));}
function qm(d,a){var b,c;c=d.h.b;sm(a,ow(c));for(b=0;b<c;++b){sm(a,Bd(fz(d.h,b),1));}return a;}
function rm(b){var a;if(b===null){return 0;}a=jm(this,b);if(a>0){return a;}az(this.h,b);a=this.h.b;mm(this,b,a);return a;}
function sm(a,b){yv(a,b);xv(a,65535);}
function tm(a){sm(this.a,a);}
function um(a){return im(this,sw(a));}
function vm(a){var b,c;c=yc(a);b=ic(this.f,c);if(b!==null){c+='/'+b;}return c;}
function wm(a){lm(this,sw(a),this.c++);}
function xm(a,b){kc(this.f,this,a,b);}
function em(){}
_=em.prototype=new jl();_.l=rm;_.o=tm;_.y=um;_.A=vm;_.yb=wm;_.zb=xm;_.tN=hC+'ClientSerializationStreamWriter';_.tI=0;_.a=null;_.b=null;_.c=0;_.d=null;_.e=null;_.f=null;_.g=null;function Er(b,a){Fr(b,bs(b)+Ad(45)+a);}
function Fr(b,a){ms(b.i,a,true);}
function bs(a){return ks(a.i);}
function cs(b,a){ds(b,bs(b)+Ad(45)+a);}
function ds(b,a){ms(b.i,a,false);}
function es(d,b,a){var c=b.parentNode;if(!c){return;}c.insertBefore(a,b);c.removeChild(b);}
function fs(b,a){if(b.i!==null){es(b,b.i,a);}b.i=a;}
function gs(b,a){ls(b.i,a);}
function hs(a,b){tg(a.i,'width',b);}
function is(b,a){ug(b.i,a|fg(b.i));}
function js(a){return eg(a,'className');}
function ks(a){var b,c;b=js(a);c=aw(b,32);if(c>=0){return gw(b,0,c);}return b;}
function ls(a,b){pg(a,'className',b);}
function ms(c,j,a){var b,d,e,f,g,h,i;if(c===null){throw rv(new qv(),'Null widget handle. If you are creating a composite, ensure that initWidget() has been called.');}j=hw(j);if(dw(j)==0){throw hu(new gu(),'Style names cannot be empty');}i=js(c);e=bw(i,j);while(e!=(-1)){if(e==0||Ev(i,e-1)==32){f=e+dw(j);g=dw(i);if(f==g||f<g&&Ev(i,f)==32){break;}}e=cw(i,j,e+1);}if(a){if(e==(-1)){if(dw(i)>0){i+=' ';}pg(c,'className',i+j);}}else{if(e!=(-1)){b=hw(gw(i,0,e));d=hw(fw(i,e+dw(j)));if(dw(b)==0){h=d;}else if(dw(d)==0){h=b;}else{h=b+' '+d;}pg(c,'className',h);}}}
function Dr(){}
_=Dr.prototype=new mv();_.tN=iC+'UIObject';_.tI=0;_.i=null;function ht(a){if(a.g){throw ku(new ju(),"Should only call onAttach when the widget is detached from the browser's document");}a.g=true;qg(a.i,a);a.s();a.lb();}
function it(a){if(!a.g){throw ku(new ju(),"Should only call onDetach when the widget is attached to the browser's document");}try{a.mb();}finally{a.u();qg(a.i,null);a.g=false;}}
function jt(a){if(a.h!==null){a.h.wb(a);}else if(a.h!==null){throw ku(new ju(),"This widget's parent does not implement HasWidgets");}}
function kt(b,a){if(b.g){qg(b.i,null);}fs(b,a);if(b.g){qg(a,b);}}
function lt(c,b){var a;a=c.h;if(b===null){if(a!==null&&a.g){it(c);}c.h=null;}else{if(a!==null){throw ku(new ju(),'Cannot set a new parent without first clearing the old parent');}c.h=b;if(b.g){ht(c);}}}
function mt(){}
function nt(){}
function ot(a){}
function pt(){}
function qt(){}
function rt(a){kt(this,a);}
function us(){}
_=us.prototype=new Dr();_.s=mt;_.u=nt;_.eb=ot;_.lb=pt;_.mb=qt;_.Ab=rt;_.tN=iC+'Widget';_.tI=26;_.g=false;_.h=null;function vq(b,a){lt(a,b);}
function xq(b,a){lt(a,null);}
function yq(){var a,b;for(b=this.ab();zs(b);){a=As(b);ht(a);}}
function zq(){var a,b;for(b=this.ab();zs(b);){a=As(b);it(a);}}
function Aq(){}
function Bq(){}
function uq(){}
_=uq.prototype=new us();_.s=yq;_.u=zq;_.lb=Aq;_.mb=Bq;_.tN=iC+'Panel';_.tI=27;function Bn(a){a.f=Es(new vs(),a);}
function Cn(a){Bn(a);return a;}
function Dn(c,a,b){jt(a);Fs(c.f,a);of(b,a.i);vq(c,a);}
function Fn(b,c){var a;if(c.h!==b){return false;}xq(b,c);a=c.i;kg(gg(a),a);ft(b.f,c);return true;}
function ao(){return dt(this.f);}
function bo(a){return Fn(this,a);}
function An(){}
_=An.prototype=new uq();_.ab=ao;_.wb=bo;_.tN=iC+'ComplexPanel';_.tI=28;function Am(a){Cn(a);a.Ab(rf());tg(a.i,'position','relative');tg(a.i,'overflow','hidden');return a;}
function Bm(a,b){Dn(a,b,a.i);}
function Dm(a){tg(a,'left','');tg(a,'top','');tg(a,'position','');}
function Em(b){var a;a=Fn(this,b);if(a){Dm(b.i);}return a;}
function zm(){}
_=zm.prototype=new An();_.wb=Em;_.tN=iC+'AbsolutePanel';_.tI=29;function fo(){fo=DB;ut(),wt;}
function eo(b,a){ut(),wt;ho(b,a);return b;}
function go(b,a){switch(bg(a)){case 1:if(b.d!==null){yn(b.d,b);}break;case 4096:case 2048:break;case 128:case 512:case 256:break;}}
function ho(b,a){kt(b,a);is(b,7041);}
function io(b,a){ng(b.i,'disabled',!a);}
function jo(a){if(this.d===null){this.d=wn(new vn());}az(this.d,a);}
function ko(a){go(this,a);}
function lo(a){ho(this,a);}
function co(){}
_=co.prototype=new us();_.k=jo;_.eb=ko;_.Ab=lo;_.tN=iC+'FocusWidget';_.tI=30;_.d=null;function cn(){cn=DB;ut(),wt;}
function bn(b,a){ut(),wt;eo(b,a);return b;}
function dn(b,a){rg(b.i,a);}
function an(){}
_=an.prototype=new co();_.tN=iC+'ButtonBase';_.tI=31;function gn(){gn=DB;ut(),wt;}
function en(a){ut(),wt;bn(a,qf());hn(a.i);gs(a,'gwt-Button');return a;}
function fn(b,a){ut(),wt;en(b);dn(b,a);return b;}
function hn(b){gn();if(b.type=='submit'){try{b.setAttribute('type','button');}catch(a){}}}
function Fm(){}
_=Fm.prototype=new an();_.tN=iC+'Button';_.tI=32;function kn(a){Cn(a);a.e=wf();a.d=tf();of(a.e,a.d);a.Ab(a.e);return a;}
function mn(a,b){if(b.h!==a){return null;}return gg(b.i);}
function on(c,d,a){var b;b=mn(c,d);if(b!==null){nn(c,b,a);}}
function nn(c,b,a){pg(b,'align',a.a);}
function pn(c,b,a){tg(b,'verticalAlign',a.a);}
function jn(){}
_=jn.prototype=new An();_.tN=iC+'CellPanel';_.tI=33;_.d=null;_.e=null;function Bw(d,a,b){var c;while(a.F()){c=a.cb();if(b===null?c===null:b.eQ(c)){return a;}}return null;}
function Dw(a){throw yw(new xw(),'add');}
function Ew(b){var a;a=Bw(this,this.ab(),b);return a!==null;}
function Aw(){}
_=Aw.prototype=new mv();_.n=Dw;_.q=Ew;_.tN=lC+'AbstractCollection';_.tI=0;function ix(b,a){throw nu(new mu(),'Index: '+a+', Size: '+b.b);}
function jx(b,a){throw yw(new xw(),'add');}
function kx(a){this.m(this.Bb(),a);return true;}
function lx(e){var a,b,c,d,f;if(e===this){return true;}if(!Cd(e,2)){return false;}f=Bd(e,2);if(this.Bb()!=f.Bb()){return false;}c=this.ab();d=f.ab();while(c.F()){a=c.cb();b=d.cb();if(!(a===null?b===null:a.eQ(b))){return false;}}return true;}
function mx(){var a,b,c,d;c=1;a=31;b=this.ab();while(b.F()){d=b.cb();c=31*c+(d===null?0:d.hC());}return c;}
function nx(){return bx(new ax(),this);}
function ox(a){throw yw(new xw(),'remove');}
function Fw(){}
_=Fw.prototype=new Aw();_.m=jx;_.n=kx;_.eQ=lx;_.hC=mx;_.ab=nx;_.vb=ox;_.tN=lC+'AbstractList';_.tI=34;function Dy(a){{bz(a);}}
function Ey(a){Dy(a);return a;}
function Fy(c,a,b){if(a<0||a>c.b){ix(c,a);}lz(c.a,a,b);++c.b;}
function az(b,a){uz(b.a,b.b++,a);return true;}
function cz(a){bz(a);}
function bz(a){a.a=id();a.b=0;}
function ez(b,a){return gz(b,a)!=(-1);}
function fz(b,a){if(a<0||a>=b.b){ix(b,a);}return qz(b.a,a);}
function gz(b,a){return hz(b,a,0);}
function hz(c,b,a){if(a<0){ix(c,a);}for(;a<c.b;++a){if(pz(b,qz(c.a,a))){return a;}}return (-1);}
function iz(a){return a.b==0;}
function jz(c,a){var b;b=fz(c,a);sz(c.a,a,1);--c.b;return b;}
function kz(c,b){var a;a=gz(c,b);if(a==(-1)){return false;}jz(c,a);return true;}
function mz(a,b){Fy(this,a,b);}
function nz(a){return az(this,a);}
function lz(a,b,c){a.splice(b,0,c);}
function oz(a){return ez(this,a);}
function pz(a,b){return a===b||a!==null&&a.eQ(b);}
function rz(a){return fz(this,a);}
function qz(a,b){return a[b];}
function tz(a){return jz(this,a);}
function sz(a,c,b){a.splice(c,b);}
function uz(a,b,c){a[b]=c;}
function vz(){return this.b;}
function Cy(){}
_=Cy.prototype=new Fw();_.m=mz;_.n=nz;_.q=oz;_.D=rz;_.vb=tz;_.Bb=vz;_.tN=lC+'ArrayList';_.tI=35;_.a=null;_.b=0;function rn(a){Ey(a);return a;}
function tn(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),12);b.fb(c);}}
function qn(){}
_=qn.prototype=new Cy();_.tN=iC+'ChangeListenerCollection';_.tI=36;function wn(a){Ey(a);return a;}
function yn(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),13);b.gb(c);}}
function vn(){}
_=vn.prototype=new Cy();_.tN=iC+'ClickListenerCollection';_.tI=37;function Ap(a){a.Ab(rf());is(a,131197);gs(a,'gwt-Label');return a;}
function Bp(b,a){Ap(b);Dp(b,a);return b;}
function Dp(b,a){sg(b.i,a);}
function Ep(a){switch(bg(a)){case 1:break;case 4:case 8:case 64:case 16:case 32:break;case 131072:break;}}
function zp(){}
_=zp.prototype=new us();_.eb=Ep;_.tN=iC+'Label';_.tI=38;function no(a){Ap(a);a.Ab(rf());is(a,125);gs(a,'gwt-HTML');return a;}
function oo(b,a){no(b);qo(b,a);return b;}
function qo(b,a){rg(b.i,a);}
function mo(){}
_=mo.prototype=new zp();_.tN=iC+'HTML';_.tI=39;function xo(){xo=DB;vo(new uo(),'center');yo=vo(new uo(),'left');zo=vo(new uo(),'right');}
var yo,zo;function vo(b,a){b.a=a;return b;}
function uo(){}
_=uo.prototype=new mv();_.tN=iC+'HasHorizontalAlignment$HorizontalAlignmentConstant';_.tI=0;_.a=null;function Fo(){Fo=DB;Do(new Co(),'bottom');Do(new Co(),'middle');ap=Do(new Co(),'top');}
var ap;function Do(a,b){a.a=b;return a;}
function Co(){}
_=Co.prototype=new mv();_.tN=iC+'HasVerticalAlignment$VerticalAlignmentConstant';_.tI=0;_.a=null;function ep(a){a.a=(xo(),yo);a.c=(Fo(),ap);}
function fp(a){kn(a);ep(a);a.b=vf();of(a.d,a.b);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function gp(b,c){var a;a=ip(b);of(b.b,a);Dn(b,c,a);}
function ip(b){var a;a=uf();nn(b,a,b.a);pn(b,a,b.c);return a;}
function jp(c){var a,b;b=gg(c.i);a=Fn(this,c);if(a){kg(this.b,b);}return a;}
function dp(){}
_=dp.prototype=new jn();_.wb=jp;_.tN=iC+'HorizontalPanel';_.tI=40;_.b=null;function rp(a){Ey(a);return a;}
function tp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.ib(e,b,d);}}
function up(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.jb(e,b,d);}}
function vp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.kb(e,b,d);}}
function wp(d,c,a){var b;b=xp(a);switch(bg(a)){case 128:tp(d,c,Dd(Ef(a)),b);break;case 512:vp(d,c,Dd(Ef(a)),b);break;case 256:up(d,c,Dd(Ef(a)),b);break;}}
function xp(a){return (ag(a)?1:0)|(Ff(a)?8:0)|(Df(a)?2:0)|(Cf(a)?4:0);}
function qp(){}
_=qp.prototype=new Cy();_.tN=iC+'KeyboardListenerCollection';_.tI=41;function jq(){jq=DB;ut(),wt;sq=new aq();}
function fq(a){jq();gq(a,false);return a;}
function gq(b,a){jq();eo(b,sf(a));is(b,1024);gs(b,'gwt-ListBox');return b;}
function hq(b,a){nq(b,a,(-1));}
function iq(b,a){if(a<0||a>=kq(b)){throw new mu();}}
function kq(a){return cq(sq,a.i);}
function lq(a){return dg(a.i,'selectedIndex');}
function mq(b,a){iq(b,a);return dq(sq,b.i,a);}
function nq(c,b,a){oq(c,b,b,a);}
function oq(c,b,d,a){ig(c.i,b,d,a);}
function pq(c,a,b){iq(c,a);eq(sq,c.i,a,b);}
function qq(b,a){ng(b.i,'multiple',a);}
function rq(a,b){og(a.i,'size',b);}
function tq(a){if(bg(a)==1024){}else{go(this,a);}}
function Fp(){}
_=Fp.prototype=new co();_.eb=tq;_.tN=iC+'ListBox';_.tI=42;var sq;function cq(b,a){return a.options.length;}
function dq(c,b,a){return b.options[a].value;}
function eq(d,b,a,c){b.options[a].selected=c;}
function aq(){}
_=aq.prototype=new mv();_.tN=iC+'ListBox$Impl';_.tI=0;function cr(){cr=DB;hr=sA(new yz());}
function br(b,a){cr();Am(b);if(a===null){a=dr();}b.Ab(a);ht(b);return b;}
function er(){cr();return fr(null);}
function fr(c){cr();var a,b;b=Bd(yA(hr,c),15);if(b!==null){return b;}a=null;if(hr.c==0){gr();}zA(hr,c,b=br(new Cq(),a));return b;}
function dr(){cr();return $doc.body;}
function gr(){cr();Dh(new Dq());}
function Cq(){}
_=Cq.prototype=new zm();_.tN=iC+'RootPanel';_.tI=43;var hr;function Fq(){var a,b;for(b=cy(ry((cr(),hr)));jy(b);){a=Bd(ky(b),15);if(a.g){it(a);}}}
function ar(){return null;}
function Dq(){}
_=Dq.prototype=new mv();_.nb=Fq;_.ob=ar;_.tN=iC+'RootPanel$1';_.tI=44;function xr(){xr=DB;ut(),wt;}
function ur(b,a){ut(),wt;eo(b,a);is(b,1024);return b;}
function vr(b,a){if(b.a===null){b.a=rn(new qn());}az(b.a,a);}
function wr(b,a){if(b.c===null){b.c=rp(new qp());}az(b.c,a);}
function yr(a){return eg(a.i,'value');}
function zr(c,a){var b;ng(c.i,'readOnly',a);b='readonly';if(a){Er(c,b);}else{cs(c,b);}}
function Ar(b,a){pg(b.i,'value',a!==null?a:'');}
function Br(a){if(this.b===null){this.b=wn(new vn());}az(this.b,a);}
function Cr(a){var b;go(this,a);b=bg(a);if(this.c!==null&&(b&896)!=0){wp(this.c,this,a);}else if(b==1){if(this.b!==null){yn(this.b,this);}}else if(b==1024){if(this.a!==null){tn(this.a,this);}}}
function tr(){}
_=tr.prototype=new co();_.k=Br;_.eb=Cr;_.tN=iC+'TextBoxBase';_.tI=45;_.a=null;_.b=null;_.c=null;function qr(){qr=DB;ut(),wt;}
function pr(a){ut(),wt;ur(a,xf());gs(a,'gwt-TextArea');return a;}
function rr(a,b){og(a.i,'cols',b);}
function sr(b,a){og(b.i,'rows',a);}
function or(){}
_=or.prototype=new tr();_.tN=iC+'TextArea';_.tI=46;function os(a){a.a=(xo(),yo);a.b=(Fo(),ap);}
function ps(a){kn(a);os(a);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function qs(b,d){var a,c;c=vf();a=ss(b);of(c,a);of(b.d,c);Dn(b,d,a);}
function ss(b){var a;a=uf();nn(b,a,b.a);pn(b,a,b.b);return a;}
function ts(c){var a,b;b=gg(c.i);a=Fn(this,c);if(a){kg(this.d,gg(b));}return a;}
function ns(){}
_=ns.prototype=new jn();_.wb=ts;_.tN=iC+'VerticalPanel';_.tI=47;function Es(b,a){b.b=a;b.a=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[4],null);return b;}
function Fs(a,b){ct(a,b,a.c);}
function bt(b,c){var a;for(a=0;a<b.c;++a){if(b.a[a]===c){return a;}}return (-1);}
function ct(d,e,a){var b,c;if(a<0||a>d.c){throw new mu();}if(d.c==d.a.a){c=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[d.a.a*2],null);for(b=0;b<d.a.a;++b){wd(c,b,d.a[b]);}d.a=c;}++d.c;for(b=d.c-1;b>a;--b){wd(d.a,b,d.a[b-1]);}wd(d.a,a,e);}
function dt(a){return xs(new ws(),a);}
function et(c,b){var a;if(b<0||b>=c.c){throw new mu();}--c.c;for(a=b;a<c.c;++a){wd(c.a,a,c.a[a+1]);}wd(c.a,c.c,null);}
function ft(b,c){var a;a=bt(b,c);if(a==(-1)){throw new nB();}et(b,a);}
function vs(){}
_=vs.prototype=new mv();_.tN=iC+'WidgetCollection';_.tI=0;_.a=null;_.b=null;_.c=0;function xs(b,a){b.b=a;return b;}
function zs(a){return a.a<a.b.c-1;}
function As(a){if(a.a>=a.b.c){throw new nB();}return a.b.a[++a.a];}
function Bs(){return zs(this);}
function Cs(){return As(this);}
function Ds(){if(this.a<0||this.a>=this.b.c){throw new ju();}this.b.b.wb(this.b.a[this.a--]);}
function ws(){}
_=ws.prototype=new mv();_.F=Bs;_.cb=Cs;_.ub=Ds;_.tN=iC+'WidgetCollection$WidgetIterator';_.tI=0;_.a=(-1);function ut(){ut=DB;vt=tt(new st());wt=vt;}
function tt(a){ut();return a;}
function st(){}
_=st.prototype=new mv();_.tN=jC+'FocusImpl';_.tI=0;var vt,wt;function yt(){}
_=yt.prototype=new qv();_.tN=kC+'ArrayStoreException';_.tI=48;function Dt(a,b){if(b<2||b>36){return (-1);}if(a>=48&&a<48+Bu(b,10)){return a-48;}if(a>=97&&a<b+97-10){return a-97+10;}if(a>=65&&a<b+65-10){return a-65+10;}return (-1);}
function Et(){}
_=Et.prototype=new qv();_.tN=kC+'ClassCastException';_.tI=49;function hu(b,a){rv(b,a);return b;}
function gu(){}
_=gu.prototype=new qv();_.tN=kC+'IllegalArgumentException';_.tI=50;function ku(b,a){rv(b,a);return b;}
function ju(){}
_=ju.prototype=new qv();_.tN=kC+'IllegalStateException';_.tI=51;function nu(b,a){rv(b,a);return b;}
function mu(){}
_=mu.prototype=new qv();_.tN=kC+'IndexOutOfBoundsException';_.tI=52;function gv(){gv=DB;{lv();}}
function fv(a){gv();return a;}
function hv(a){gv();return isNaN(a);}
function iv(e,d,c,h){gv();var a,b,f,g;if(e===null){throw dv(new cv(),'Unable to parse null');}b=dw(e);f=b>0&&Ev(e,0)==45?1:0;for(a=f;a<b;a++){if(Dt(Ev(e,a),d)==(-1)){throw dv(new cv(),'Could not parse '+e+' in radix '+d);}}g=jv(e,d);if(hv(g)){throw dv(new cv(),'Unable to parse '+e);}else if(g<c||g>h){throw dv(new cv(),'The string '+e+' exceeds the range for the requested data type');}return g;}
function jv(b,a){gv();return parseInt(b,a);}
function lv(){gv();kv=/^[+-]?\d*\.?\d*(e[+-]?\d+)?$/i;}
function bv(){}
_=bv.prototype=new mv();_.tN=kC+'Number';_.tI=0;var kv=null;function ru(){ru=DB;gv();}
function qu(a,b){ru();fv(a);a.a=b;return a;}
function su(a){return Cd(a,20)&&Bd(a,20).a==this.a;}
function tu(){return this.a;}
function uu(a){ru();return vu(a,10);}
function vu(b,a){ru();return Ed(iv(b,a,(-2147483648),2147483647));}
function wu(a){ru();return ow(a);}
function xu(a){ru();return qu(new pu(),uu(a));}
function pu(){}
_=pu.prototype=new bv();_.eQ=su;_.hC=tu;_.tN=kC+'Integer';_.tI=53;_.a=0;function Au(a){return a<0?-a:a;}
function Bu(a,b){return a<b?a:b;}
function Cu(){}
_=Cu.prototype=new qv();_.tN=kC+'NegativeArraySizeException';_.tI=54;function Fu(b,a){rv(b,a);return b;}
function Eu(){}
_=Eu.prototype=new qv();_.tN=kC+'NullPointerException';_.tI=55;function dv(b,a){hu(b,a);return b;}
function cv(){}
_=cv.prototype=new gu();_.tN=kC+'NumberFormatException';_.tI=56;function Ev(b,a){return b.charCodeAt(a);}
function aw(b,a){return b.indexOf(String.fromCharCode(a));}
function bw(b,a){return b.indexOf(a);}
function cw(c,b,a){return c.indexOf(b,a);}
function dw(a){return a.length;}
function ew(b,a){return bw(b,a)==0;}
function fw(b,a){return b.substr(a,b.length-a);}
function gw(c,a,b){return c.substr(a,b-a);}
function hw(c){var a=c.replace(/^(\s*)/,'');var b=a.replace(/\s*$/,'');return b;}
function iw(a,b){return String(a)==b;}
function jw(a){if(!Cd(a,1))return false;return iw(this,a);}
function lw(){var a=kw;if(!a){a=kw={};}var e=':'+this;var b=a[e];if(b==null){b=0;var f=this.length;var d=f<64?1:f/32|0;for(var c=0;c<f;c+=d){b<<=1;b+=this.charCodeAt(c);}b|=0;a[e]=b;}return b;}
function mw(a){return String.fromCharCode(a);}
function nw(a){return ''+a;}
function ow(a){return ''+a;}
_=String.prototype;_.eQ=jw;_.hC=lw;_.tN=kC+'String';_.tI=2;var kw=null;function wv(a){zv(a);return a;}
function xv(a,b){return yv(a,mw(b));}
function yv(c,d){if(d===null){d='null';}var a=c.js.length-1;var b=c.js[a].length;if(c.length>b*b){c.js[a]=c.js[a]+d;}else{c.js.push(d);}c.length+=d.length;return c;}
function zv(a){Av(a,'');}
function Av(b,a){b.js=[a];b.length=a.length;}
function Cv(a){a.db();return a.js[0];}
function Dv(){if(this.js.length>1){this.js=[this.js.join('')];this.length=this.js[0].length;}}
function vv(){}
_=vv.prototype=new mv();_.db=Dv;_.tN=kC+'StringBuffer';_.tI=0;function rw(){return new Date().getTime();}
function sw(a){return Dc(a);}
function yw(b,a){rv(b,a);return b;}
function xw(){}
_=xw.prototype=new qv();_.tN=kC+'UnsupportedOperationException';_.tI=57;function bx(b,a){b.c=a;return b;}
function dx(a){return a.a<a.c.Bb();}
function ex(){return dx(this);}
function fx(){if(!dx(this)){throw new nB();}return this.c.D(this.b=this.a++);}
function gx(){if(this.b<0){throw new ju();}this.c.vb(this.b);this.a=this.b;this.b=(-1);}
function ax(){}
_=ax.prototype=new mv();_.F=ex;_.cb=fx;_.ub=gx;_.tN=lC+'AbstractList$IteratorImpl';_.tI=0;_.a=0;_.b=(-1);function py(f,d,e){var a,b,c;for(b=nA(f.v());fA(b);){a=gA(b);c=a.z();if(d===null?c===null:d.eQ(c)){if(e){hA(b);}return a;}}return null;}
function qy(b){var a;a=b.v();return rx(new qx(),b,a);}
function ry(b){var a;a=xA(b);return ay(new Fx(),b,a);}
function sy(a){return py(this,a,false)!==null;}
function ty(d){var a,b,c,e,f,g,h;if(d===this){return true;}if(!Cd(d,21)){return false;}f=Bd(d,21);c=qy(this);e=f.bb();if(!zy(c,e)){return false;}for(a=tx(c);Ax(a);){b=Bx(a);h=this.E(b);g=f.E(b);if(h===null?g!==null:!h.eQ(g)){return false;}}return true;}
function uy(b){var a;a=py(this,b,false);return a===null?null:a.C();}
function vy(){var a,b,c;b=0;for(c=nA(this.v());fA(c);){a=gA(c);b+=a.hC();}return b;}
function wy(){return qy(this);}
function px(){}
_=px.prototype=new mv();_.p=sy;_.eQ=ty;_.E=uy;_.hC=vy;_.bb=wy;_.tN=lC+'AbstractMap';_.tI=58;function zy(e,b){var a,c,d;if(b===e){return true;}if(!Cd(b,22)){return false;}c=Bd(b,22);if(c.Bb()!=e.Bb()){return false;}for(a=c.ab();a.F();){d=a.cb();if(!e.q(d)){return false;}}return true;}
function Ay(a){return zy(this,a);}
function By(){var a,b,c;a=0;for(b=this.ab();b.F();){c=b.cb();if(c!==null){a+=c.hC();}}return a;}
function xy(){}
_=xy.prototype=new Aw();_.eQ=Ay;_.hC=By;_.tN=lC+'AbstractSet';_.tI=59;function rx(b,a,c){b.a=a;b.b=c;return b;}
function tx(b){var a;a=nA(b.b);return yx(new xx(),b,a);}
function ux(a){return this.a.p(a);}
function vx(){return tx(this);}
function wx(){return this.b.a.c;}
function qx(){}
_=qx.prototype=new xy();_.q=ux;_.ab=vx;_.Bb=wx;_.tN=lC+'AbstractMap$1';_.tI=60;function yx(b,a,c){b.a=c;return b;}
function Ax(a){return fA(a.a);}
function Bx(b){var a;a=gA(b.a);return a.z();}
function Cx(){return Ax(this);}
function Dx(){return Bx(this);}
function Ex(){hA(this.a);}
function xx(){}
_=xx.prototype=new mv();_.F=Cx;_.cb=Dx;_.ub=Ex;_.tN=lC+'AbstractMap$2';_.tI=0;function ay(b,a,c){b.a=a;b.b=c;return b;}
function cy(b){var a;a=nA(b.b);return hy(new gy(),b,a);}
function dy(a){return wA(this.a,a);}
function ey(){return cy(this);}
function fy(){return this.b.a.c;}
function Fx(){}
_=Fx.prototype=new Aw();_.q=dy;_.ab=ey;_.Bb=fy;_.tN=lC+'AbstractMap$3';_.tI=0;function hy(b,a,c){b.a=c;return b;}
function jy(a){return fA(a.a);}
function ky(a){var b;b=gA(a.a).C();return b;}
function ly(){return jy(this);}
function my(){return ky(this);}
function ny(){hA(this.a);}
function gy(){}
_=gy.prototype=new mv();_.F=ly;_.cb=my;_.ub=ny;_.tN=lC+'AbstractMap$4';_.tI=0;function uA(){uA=DB;BA=bB();}
function rA(a){{tA(a);}}
function sA(a){uA();rA(a);return a;}
function tA(a){a.a=id();a.d=kd();a.b=ce(BA,ed);a.c=0;}
function vA(b,a){if(Cd(a,1)){return fB(b.d,Bd(a,1))!==BA;}else if(a===null){return b.b!==BA;}else{return eB(b.a,a,a.hC())!==BA;}}
function wA(a,b){if(a.b!==BA&&dB(a.b,b)){return true;}else if(aB(a.d,b)){return true;}else if(EA(a.a,b)){return true;}return false;}
function xA(a){return lA(new bA(),a);}
function yA(c,a){var b;if(Cd(a,1)){b=fB(c.d,Bd(a,1));}else if(a===null){b=c.b;}else{b=eB(c.a,a,a.hC());}return b===BA?null:b;}
function zA(c,a,d){var b;{b=c.b;c.b=d;}if(b===BA){++c.c;return null;}else{return b;}}
function AA(c,a){var b;if(Cd(a,1)){b=iB(c.d,Bd(a,1));}else if(a===null){b=c.b;c.b=ce(BA,ed);}else{b=hB(c.a,a,a.hC());}if(b===BA){return null;}else{--c.c;return b;}}
function CA(e,c){uA();for(var d in e){if(d==parseInt(d)){var a=e[d];for(var f=0,b=a.length;f<b;++f){c.n(a[f]);}}}}
function DA(d,a){uA();for(var c in d){if(c.charCodeAt(0)==58){var e=d[c];var b=Cz(c.substring(1),e);a.n(b);}}}
function EA(f,h){uA();for(var e in f){if(e==parseInt(e)){var a=f[e];for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.C();if(dB(h,d)){return true;}}}}return false;}
function FA(a){return vA(this,a);}
function aB(c,d){uA();for(var b in c){if(b.charCodeAt(0)==58){var a=c[b];if(dB(d,a)){return true;}}}return false;}
function bB(){uA();}
function cB(){return xA(this);}
function dB(a,b){uA();if(a===b){return true;}else if(a===null){return false;}else{return a.eQ(b);}}
function gB(a){return yA(this,a);}
function eB(f,h,e){uA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(dB(h,d)){return c.C();}}}}
function fB(b,a){uA();return b[':'+a];}
function hB(f,h,e){uA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(dB(h,d)){if(a.length==1){delete f[e];}else{a.splice(g,1);}return c.C();}}}}
function iB(c,a){uA();a=':'+a;var b=c[a];delete c[a];return b;}
function yz(){}
_=yz.prototype=new px();_.p=FA;_.v=cB;_.E=gB;_.tN=lC+'HashMap';_.tI=61;_.a=null;_.b=null;_.c=0;_.d=null;var BA;function Az(b,a,c){b.a=a;b.b=c;return b;}
function Cz(a,b){return Az(new zz(),a,b);}
function Dz(b){var a;if(Cd(b,23)){a=Bd(b,23);if(dB(this.a,a.z())&&dB(this.b,a.C())){return true;}}return false;}
function Ez(){return this.a;}
function Fz(){return this.b;}
function aA(){var a,b;a=0;b=0;if(this.a!==null){a=this.a.hC();}if(this.b!==null){b=this.b.hC();}return a^b;}
function zz(){}
_=zz.prototype=new mv();_.eQ=Dz;_.z=Ez;_.C=Fz;_.hC=aA;_.tN=lC+'HashMap$EntryImpl';_.tI=62;_.a=null;_.b=null;function lA(b,a){b.a=a;return b;}
function nA(a){return dA(new cA(),a.a);}
function oA(c){var a,b,d;if(Cd(c,23)){a=Bd(c,23);b=a.z();if(vA(this.a,b)){d=yA(this.a,b);return dB(a.C(),d);}}return false;}
function pA(){return nA(this);}
function qA(){return this.a.c;}
function bA(){}
_=bA.prototype=new xy();_.q=oA;_.ab=pA;_.Bb=qA;_.tN=lC+'HashMap$EntrySet';_.tI=63;function dA(c,b){var a;c.c=b;a=Ey(new Cy());if(c.c.b!==(uA(),BA)){az(a,Az(new zz(),null,c.c.b));}DA(c.c.d,a);CA(c.c.a,a);c.a=a.ab();return c;}
function fA(a){return a.a.F();}
function gA(a){return a.b=Bd(a.a.cb(),23);}
function hA(a){if(a.b===null){throw ku(new ju(),'Must call next() before remove().');}else{a.a.ub();AA(a.c,a.b.z());a.b=null;}}
function iA(){return fA(this);}
function jA(){return gA(this);}
function kA(){hA(this);}
function cA(){}
_=cA.prototype=new mv();_.F=iA;_.cb=jA;_.ub=kA;_.tN=lC+'HashMap$EntrySetIterator';_.tI=0;_.a=null;_.b=null;function nB(){}
_=nB.prototype=new qv();_.tN=lC+'NoSuchElementException';_.tI=64;function sB(a){a.a=Ey(new Cy());return a;}
function tB(b,a){return az(b.a,a);}
function vB(a){return a.a.ab();}
function wB(a,b){Fy(this.a,a,b);}
function xB(a){return tB(this,a);}
function yB(a){return ez(this.a,a);}
function zB(a){return fz(this.a,a);}
function AB(){return vB(this);}
function BB(a){return jz(this.a,a);}
function CB(){return this.a.b;}
function rB(){}
_=rB.prototype=new Fw();_.m=wB;_.n=xB;_.q=yB;_.D=zB;_.ab=AB;_.vb=BB;_.Bb=CB;_.tN=lC+'Vector';_.tI=65;_.a=null;function xt(){vb(new ab());}
function gwtOnLoad(b,d,c){$moduleName=d;$moduleBase=c;if(b)try{xt();}catch(a){b(d);}else{xt();}}
var be=[{},{},{1:1},{3:1},{11:1},{7:1},{12:1},{14:1},{14:1},{13:1},{5:1},{5:1},{5:1},{5:1},{6:1},{5:1},{9:1},{9:1},{9:1},{6:1,8:1},{6:1},{10:1},{5:1},{5:1},{4:1,5:1},{5:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{2:1},{2:1},{2:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{16:1,17:1,18:1,19:1},{15:1,16:1,17:1,18:1,19:1},{10:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{5:1},{5:1},{5:1},{5:1},{5:1},{20:1},{5:1},{5:1},{5:1},{5:1},{21:1},{22:1},{22:1},{21:1},{23:1},{22:1},{5:1},{2:1}];if (TFDSSummarizer) {  var __gwt_initHandlers = TFDSSummarizer.__gwt_initHandlers;  TFDSSummarizer.onScriptLoad(gwtOnLoad);}})();