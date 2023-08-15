(function(){var $wnd = window;var $doc = $wnd.document;var $moduleName, $moduleBase;var _,hC='client.',iC='client.service.',jC='com.google.gwt.core.client.',kC='com.google.gwt.lang.',lC='com.google.gwt.user.client.',mC='com.google.gwt.user.client.impl.',nC='com.google.gwt.user.client.rpc.',oC='com.google.gwt.user.client.rpc.core.java.lang.',pC='com.google.gwt.user.client.rpc.core.java.util.',qC='com.google.gwt.user.client.rpc.impl.',rC='com.google.gwt.user.client.ui.',sC='com.google.gwt.user.client.ui.impl.',tC='java.lang.',uC='java.util.';function gC(){}
function xv(a){return this===a;}
function yv(){return Bw(this);}
function vv(){}
_=vv.prototype={};_.eQ=xv;_.hC=yv;_.tN=tC+'Object';_.tI=1;function s(){}
_=s.prototype=new vv();_.tN=hC+'Sentence';_.tI=3;_.a=0.0;_.b=0;_.c=0;_.d='';function w(b,a){C(a,b.qb());D(a,b.rb());E(a,b.rb());F(a,b.tb());}
function x(a){return a.a;}
function y(a){return a.b;}
function z(a){return a.c;}
function A(a){return a.d;}
function B(b,a){b.Cb(x(a));b.Db(y(a));b.Db(z(a));b.Fb(A(a));}
function C(a,b){a.a=b;}
function D(a,b){a.b=b;}
function E(a,b){a.c=b;}
function F(a,b){a.d=b;}
function vb(r){var a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q;c=Dp(new Bp(),'Input text to be summarized:');g=rr(new qr());tr(g,80);ur(g,25);a=hn(new bn(),'Summarize');o=Dp(new Bp(),'Summary Size (% of original):');p=hq(new bq());for(b=1;b<=100;b++)jq(p,Fu(b));sq(p,false);tq(p,1);rq(p,9,true);d=hp(new fp());ip(d,a);ip(d,o);ip(d,p);qn(d,o,(zo(),Bo));qn(d,p,(zo(),Bo));js(d,'95%');e=rs(new ps());ss(e,c);ss(e,g);ss(e,d);j=Dp(new Bp(),'System-generated Summary:');l=rr(new qr());tr(l,80);ur(l,25);Br(l,true);n=po(new oo());k=rs(new ps());ss(k,j);ss(k,l);ss(k,n);f=qo(new oo(),'<br><br><br>This summarizer implements the frequency distribution summarization algorithm (using terms rather than concepts) described in these papers:<br><br>Lawrence H. Reeve, Hyoil Han, Saya V. Nagori, Jonathan C. Yang, Tamara A. Schwimmer, and Ari D. Brooks (2006).<br><EM><A href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2006CIKM.pdf">Concept Frequency Distribution in Biomedical Text Summarization<\/A>.<\/EM><br><A href="http://sa1.sice.umkc.edu/cikm2006/"> <FONT face="Times New Roman">Proceedings of the 15th Conference on Information and Knowledge Management<\/FONT><\/A><FONT face="Times New Roman"><\/FONT><A href="http://www.cs.iupui.edu/%7Ebioin/"><\/A>.<br><br>Lawrence H. Reeve and Hyoil Han (2007).<br><EM><a href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2007DUC.pdf">A Term Frequency Distribution Approach for the DUC-2007 Update Task.<\/a><\/EM><br>Proceedings of the 2007 Document Understanding Conference Workshop (DUC 2007)<br><br>');m=hp(new fp());ip(m,f);h=hp(new fp());ip(h,e);ip(h,k);Eh(r);Dm(gr(),h);Dm(gr(),m);r.b=Eb(new yb());q=r.b;i=xc()+'summarizerservice';bc(q,i);r.a=cb(new bb(),r,l,n,a);zg(new gb());ei(),di();xr(g,new jb());yr(g,nb(new mb(),r,l));a.k(rb(new qb(),r,a,l,n,g,p));}
function wb(b,a){}
function ab(){}
_=ab.prototype=new vv();_.pb=wb;_.tN=hC+'TFDSSummarizer';_.tI=4;_.a=null;_.b=null;function cb(b,a,d,e,c){b.b=d;b.c=e;b.a=c;return b;}
function eb(b,a){so(b.c,'Server Response:\n\n'+a.a);ko(b.a,true);}
function fb(g,c){var a,b,d,e,f;f=Bd(c,2);b=Fv(new Ev());for(a=0;a<f.Bb();a++){d=Bd(f.D(a),3);if(d.c==0){e=d.d;if(e!==null&&mw(e)!=0){bw(b,d.d);bw(b,'\n\n');}}else{bw(b,'['+d.c+']: '+d.d);bw(b,'\n\n');}}Cr(g.b,fw(b));Fp(g.c,'');ko(g.a,true);}
function bb(){}
_=bb.prototype=new vv();_.tN=hC+'TFDSSummarizer$1';_.tI=0;function ib(){ei(),di();}
function gb(){}
_=gb.prototype=new vv();_.w=ib;_.tN=hC+'TFDSSummarizer$2';_.tI=5;function lb(a){}
function jb(){}
_=jb.prototype=new vv();_.fb=lb;_.tN=hC+'TFDSSummarizer$3';_.tI=6;function pp(c,a,b){}
function qp(c,a,b){}
function rp(c,a,b){}
function np(){}
_=np.prototype=new vv();_.ib=pp;_.jb=qp;_.kb=rp;_.tN=rC+'KeyboardListenerAdapter';_.tI=7;function nb(b,a,c){b.a=c;return b;}
function pb(d,a,b){var c;c=Ar(this.a);if(c!==null&&mw(c)>0)Cr(this.a,'');}
function mb(){}
_=mb.prototype=new np();_.jb=pb;_.tN=hC+'TFDSSummarizer$4';_.tI=8;function rb(b,a,c,e,f,d,g){b.a=a;b.b=c;b.d=e;b.e=f;b.c=d;b.f=g;return b;}
function tb(a){ko(this.b,false);Cr(this.d,'');so(this.e,'<b><i>Please wait...summarizing the source text.<\/i><\/b>');cc(this.a.b,Ar(this.c),av(oq(this.f,nq(this.f))),this.a.a);}
function qb(){}
_=qb.prototype=new vv();_.gb=tb;_.tN=hC+'TFDSSummarizer$5';_.tI=9;function ac(){ac=gC;dc=fc(new ec());}
function Eb(a){ac();return a;}
function Fb(d,b,c,a){if(d.a===null)throw nk(new mk());mm(b);pl(b,'client.service.ISummarizerService');pl(b,'summarizeTFDS');nl(b,2);pl(b,'java.lang.String');pl(b,'java.lang.Integer');pl(b,c);ol(b,a);}
function bc(b,a){b.a=a;}
function cc(j,i,f,c){var a,d,e,g,h;g=zl(new yl(),dc);h=im(new gm(),dc,xc(),'AF8D9E63B5457AB80016BBD0E4B3C585');try{Fb(j,h,i,f);}catch(a){a=fe(a);if(Cd(a,4)){d=a;eb(c,d);return;}else throw a;}e=Ab(new zb(),j,g,c);if(!gh(j.a,pm(h),e))eb(c,ek(new dk(),'Unable to initiate the asynchronous service invocation -- check the network connection'));}
function yb(){}
_=yb.prototype=new vv();_.tN=iC+'ISummarizerService_Proxy';_.tI=0;_.a=null;var dc;function Ab(b,a,d,c){b.b=d;b.a=c;return b;}
function Cb(g,e){var a,c,d,f;f=null;c=null;try{if(nw(e,'//OK')){Cl(g.b,ow(e,4));f=il(g.b);}else if(nw(e,'//EX')){Cl(g.b,ow(e,4));c=Bd(il(g.b),5);}else{c=ek(new dk(),e);}}catch(a){a=fe(a);if(Cd(a,4)){a;c=Dj(new Cj());}else if(Cd(a,5)){d=a;c=d;}else throw a;}if(c===null)fb(g.a,f);else eb(g.a,c);}
function Db(a){var b;b=zc;Cb(this,a);}
function zb(){}
_=zb.prototype=new vv();_.hb=Db;_.tN=iC+'ISummarizerService_Proxy$1';_.tI=0;function gc(){gc=gC;rc=lc();tc=mc();}
function fc(a){gc();return a;}
function hc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[1](c,a);}
function ic(b,c){var a=tc[c];return a==null?c:a;}
function jc(c,b,d){var a=rc[d];if(!a){sc(d);}return a[0](b);}
function kc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[2](c,a);}
function lc(){gc();return {'client.Sentence/1365443775':[function(a){return nc(a);},function(a,b){w(a,b);},function(a,b){B(a,b);}],'com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533':[function(a){return oc(a);},function(a,b){bk(a,b);},function(a,b){ck(a,b);}],'java.lang.Integer/3438268394':[function(a){return tk(a);},function(a,b){sk(a,b);},function(a,b){uk(a,b);}],'java.lang.String/2004016611':[function(a){return yk(a);},function(a,b){xk(a,b);},function(a,b){zk(a,b);}],'java.util.ArrayList/3821976829':[function(a){return pc(a);},function(a,b){Ck(a,b);},function(a,b){Dk(a,b);}],'java.util.Vector/3125574444':[function(a){return qc(a);},function(a,b){al(a,b);},function(a,b){bl(a,b);}]};}
function mc(){gc();return {'client.Sentence':'1365443775','com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException':'3936916533','java.lang.Integer':'3438268394','java.lang.String':'2004016611','java.util.ArrayList':'3821976829','java.util.Vector':'3125574444'};}
function nc(a){gc();return new s();}
function oc(a){gc();return Dj(new Cj());}
function pc(a){gc();return hz(new fz());}
function qc(a){gc();return BB(new AB());}
function sc(a){gc();throw ik(new hk(),a);}
function ec(){}
_=ec.prototype=new vv();_.tN=iC+'ISummarizerService_TypeSerializer';_.tI=0;var rc,tc;function xc(){return Ec();}
function yc(a){return a==null?null:a.tN;}
var zc=null;function Cc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Dc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Ec(){return $moduleBase;}
function Fc(){return ++ad;}
var ad=0;function Dw(b,a){b.a=a;return b;}
function Ew(c,b,a){c.a=b;return c;}
function Cw(){}
_=Cw.prototype=new vv();_.tN=tC+'Throwable';_.tI=10;_.a=null;function mu(b,a){Dw(b,a);return b;}
function nu(c,b,a){Ew(c,b,a);return c;}
function lu(){}
_=lu.prototype=new Cw();_.tN=tC+'Exception';_.tI=11;function Av(b,a){mu(b,a);return b;}
function Bv(c,b,a){nu(c,b,a);return c;}
function zv(){}
_=zv.prototype=new lu();_.tN=tC+'RuntimeException';_.tI=12;function cd(c,b,a){Av(c,'JavaScript '+b+' exception: '+a);return c;}
function bd(){}
_=bd.prototype=new zv();_.tN=jC+'JavaScriptException';_.tI=13;function gd(b,a){if(!Cd(a,6)){return false;}return ld(b,Bd(a,6));}
function hd(a){return Cc(a);}
function id(){return [];}
function jd(){return function(){};}
function kd(){return {};}
function md(a){return gd(this,a);}
function ld(a,b){return a===b;}
function nd(){return hd(this);}
function ed(){}
_=ed.prototype=new vv();_.eQ=md;_.hC=nd;_.tN=jC+'JavaScriptObject';_.tI=14;function pd(c,a,d,b,e){c.a=a;c.b=b;c.tN=e;c.tI=d;return c;}
function rd(a,b,c){return a[b]=c;}
function sd(b,a){return b[a];}
function td(a){return a.length;}
function vd(e,d,c,b,a){return ud(e,d,c,b,0,td(b),a);}
function ud(j,i,g,c,e,a,b){var d,f,h;if((f=sd(c,e))<0){throw new fv();}h=pd(new od(),f,sd(i,e),sd(g,e),j);++e;if(e<a){j=ow(j,1);for(d=0;d<f;++d){rd(h,d,ud(j,i,g,c,e,a,b));}}else{for(d=0;d<f;++d){rd(h,d,b);}}return h;}
function wd(a,b,c){if(c!==null&&a.b!=0&& !Cd(c,a.b)){throw new bu();}return rd(a,b,c);}
function od(){}
_=od.prototype=new vv();_.tN=kC+'Array';_.tI=0;function zd(b,a){return !(!(b&&be[b][a]));}
function Ad(a){return String.fromCharCode(a);}
function Bd(b,a){if(b!=null)zd(b.tI,a)||ae();return b;}
function Cd(b,a){return b!=null&&zd(b.tI,a);}
function Dd(a){return a&65535;}
function Ed(a){return ~(~a);}
function ae(){throw new hu();}
function Fd(a){if(a!==null){throw new hu();}return a;}
function ce(b,d){_=d.prototype;if(b&& !(b.tI>=_.tI)){var c=b.toString;for(var a in _){b[a]=_[a];}b.toString=c;}return b;}
var be;function fe(a){if(Cd(a,5)){return a;}return cd(new bd(),he(a),ge(a));}
function ge(a){return a.message;}
function he(a){return a.name;}
function je(b,a){return b;}
function ie(){}
_=ie.prototype=new zv();_.tN=lC+'CommandCanceledException';_.tI=15;function af(a){a.a=ne(new me(),a);a.b=hz(new fz());a.d=re(new qe(),a);a.f=ve(new ue(),a);}
function bf(a){af(a);return a;}
function df(c){var a,b,d;a=xe(c.f);Ae(c.f);b=null;if(Cd(a,7)){b=je(new ie(),Bd(a,7));}else{}if(b!==null){d=zc;}gf(c,false);ff(c);}
function ef(e,d){var a,b,c,f;f=false;try{gf(e,true);Be(e.f,e.b.b);sh(e.a,10000);while(ye(e.f)){b=ze(e.f);c=true;try{if(b===null){return;}if(Cd(b,7)){a=Bd(b,7);a.w();}else{}}finally{f=Ce(e.f);if(f){return;}if(c){Ae(e.f);}}if(kf(Aw(),d)){return;}}}finally{if(!f){ph(e.a);gf(e,false);ff(e);}}}
function ff(a){if(!rz(a.b)&& !a.e&& !a.c){hf(a,true);sh(a.d,1);}}
function gf(b,a){b.c=a;}
function hf(b,a){b.e=a;}
function jf(b,a){jz(b.b,a);ff(b);}
function kf(a,b){return dv(a-b)>=100;}
function le(){}
_=le.prototype=new vv();_.tN=lC+'CommandExecutor';_.tI=0;_.c=false;_.e=false;function qh(){qh=gC;yh=hz(new fz());{xh();}}
function oh(a){qh();return a;}
function ph(a){if(a.b){th(a.c);}else{uh(a.c);}tz(yh,a);}
function rh(a){if(!a.b){tz(yh,a);}a.xb();}
function sh(b,a){if(a<=0){throw qu(new pu(),'must be positive');}ph(b);b.b=false;b.c=vh(b,a);jz(yh,b);}
function th(a){qh();$wnd.clearInterval(a);}
function uh(a){qh();$wnd.clearTimeout(a);}
function vh(b,a){qh();return $wnd.setTimeout(function(){b.x();},a);}
function wh(){var a;a=zc;{rh(this);}}
function xh(){qh();Dh(new kh());}
function jh(){}
_=jh.prototype=new vv();_.x=wh;_.tN=lC+'Timer';_.tI=16;_.b=false;_.c=0;var yh;function oe(){oe=gC;qh();}
function ne(b,a){oe();b.a=a;oh(b);return b;}
function pe(){if(!this.a.c){return;}df(this.a);}
function me(){}
_=me.prototype=new jh();_.xb=pe;_.tN=lC+'CommandExecutor$1';_.tI=17;function se(){se=gC;qh();}
function re(b,a){se();b.a=a;oh(b);return b;}
function te(){hf(this.a,false);ef(this.a,Aw());}
function qe(){}
_=qe.prototype=new jh();_.xb=te;_.tN=lC+'CommandExecutor$2';_.tI=18;function ve(b,a){b.d=a;return b;}
function xe(a){return oz(a.d.b,a.b);}
function ye(a){return a.c<a.a;}
function ze(b){var a;b.b=b.c;a=oz(b.d.b,b.c++);if(b.c>=b.a){b.c=0;}return a;}
function Ae(a){sz(a.d.b,a.b);--a.a;if(a.b<=a.c){if(--a.c<0){a.c=0;}}a.b=(-1);}
function Be(b,a){b.a=a;}
function Ce(a){return a.b==(-1);}
function De(){return ye(this);}
function Ee(){return ze(this);}
function Fe(){Ae(this);}
function ue(){}
_=ue.prototype=new vv();_.F=De;_.cb=Ee;_.ub=Fe;_.tN=lC+'CommandExecutor$CircularIterator';_.tI=0;_.a=0;_.b=(-1);_.c=0;function nf(){nf=gC;mg=hz(new fz());{hg=new mi();ri(hg);}}
function of(b,a){nf();Ai(hg,b,a);}
function pf(a,b){nf();return pi(hg,a,b);}
function qf(){nf();return Ci(hg,'button');}
function rf(){nf();return Ci(hg,'div');}
function sf(a){nf();return Di(hg,a);}
function tf(){nf();return Ci(hg,'tbody');}
function uf(){nf();return Ci(hg,'td');}
function vf(){nf();return Ci(hg,'tr');}
function wf(){nf();return Ci(hg,'table');}
function xf(){nf();return Ci(hg,'textarea');}
function Af(b,a,d){nf();var c;c=zc;{zf(b,a,d);}}
function zf(b,a,c){nf();var d;if(a===lg){if(bg(b)==8192){lg=null;}}d=yf;yf=b;try{c.eb(b);}finally{yf=d;}}
function Bf(b,a){nf();Ei(hg,b,a);}
function Cf(a){nf();return Fi(hg,a);}
function Df(a){nf();return aj(hg,a);}
function Ef(a){nf();return bj(hg,a);}
function Ff(a){nf();return cj(hg,a);}
function ag(a){nf();return dj(hg,a);}
function bg(a){nf();return ej(hg,a);}
function cg(a){nf();wi(hg,a);}
function eg(a,b){nf();return gj(hg,a,b);}
function dg(a,b){nf();return fj(hg,a,b);}
function fg(a){nf();return hj(hg,a);}
function gg(a){nf();return xi(hg,a);}
function ig(c,b,d,a){nf();ij(hg,c,b,d,a);}
function jg(a){nf();var b,c;c=true;if(mg.b>0){b=Fd(oz(mg,mg.b-1));if(!(c=null.bc())){Bf(a,true);cg(a);}}return c;}
function kg(b,a){nf();jj(hg,b,a);}
function pg(a,b,c){nf();mj(hg,a,b,c);}
function ng(a,b,c){nf();kj(hg,a,b,c);}
function og(a,b,c){nf();lj(hg,a,b,c);}
function qg(a,b){nf();nj(hg,a,b);}
function rg(a,b){nf();oj(hg,a,b);}
function sg(a,b){nf();pj(hg,a,b);}
function tg(b,a,c){nf();qj(hg,b,a,c);}
function ug(a,b){nf();ti(hg,a,b);}
function vg(){nf();return rj(hg);}
function wg(){nf();return sj(hg);}
var yf=null,hg=null,lg=null,mg;function yg(){yg=gC;Ag=bf(new le());}
function zg(a){yg();if(a===null){throw iv(new hv(),'cmd can not be null');}jf(Ag,a);}
var Ag;function Dg(a){if(Cd(a,8)){return pf(this,Bd(a,8));}return gd(ce(this,Bg),a);}
function Eg(){return hd(ce(this,Bg));}
function Bg(){}
_=Bg.prototype=new ed();_.eQ=Dg;_.hC=Eg;_.tN=lC+'Element';_.tI=19;function ch(a){return gd(ce(this,Fg),a);}
function dh(){return hd(ce(this,Fg));}
function Fg(){}
_=Fg.prototype=new ed();_.eQ=ch;_.hC=dh;_.tN=lC+'Event';_.tI=20;function fh(){fh=gC;hh=uj(new tj());}
function gh(c,b,a){fh();return wj(hh,c,b,a);}
var hh;function mh(){while((qh(),yh).b>0){ph(Bd(oz((qh(),yh),0),9));}}
function nh(){return null;}
function kh(){}
_=kh.prototype=new vv();_.nb=mh;_.ob=nh;_.tN=lC+'Timer$1';_.tI=21;function Ch(){Ch=gC;Fh=hz(new fz());ji=hz(new fz());{fi();}}
function Dh(a){Ch();jz(Fh,a);}
function Eh(a){Ch();jz(ji,a);}
function ai(){Ch();var a,b;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);b.nb();}}
function bi(){Ch();var a,b,c,d;d=null;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);c=b.ob();{d=c;}}return d;}
function ci(){Ch();var a,b;for(a=ji.ab();a.F();){b=Bd(a.cb(),11);b.pb(ei(),di());}}
function di(){Ch();return vg();}
function ei(){Ch();return wg();}
function fi(){Ch();__gwt_initHandlers(function(){ii();},function(){return hi();},function(){gi();$wnd.onresize=null;$wnd.onbeforeclose=null;$wnd.onclose=null;});}
function gi(){Ch();var a;a=zc;{ai();}}
function hi(){Ch();var a;a=zc;{return bi();}}
function ii(){Ch();var a;a=zc;{ci();}}
var Fh,ji;function Ai(c,b,a){b.appendChild(a);}
function Ci(b,a){return $doc.createElement(a);}
function Di(c,a){var b;b=Ci(c,'select');if(a){kj(c,b,'multiple',true);}return b;}
function Ei(c,b,a){b.cancelBubble=a;}
function Fi(b,a){return !(!a.altKey);}
function aj(b,a){return !(!a.ctrlKey);}
function bj(b,a){return a.which||(a.keyCode|| -1);}
function cj(b,a){return !(!a.metaKey);}
function dj(b,a){return !(!a.shiftKey);}
function ej(b,a){switch(a.type){case 'blur':return 4096;case 'change':return 1024;case 'click':return 1;case 'dblclick':return 2;case 'focus':return 2048;case 'keydown':return 128;case 'keypress':return 256;case 'keyup':return 512;case 'load':return 32768;case 'losecapture':return 8192;case 'mousedown':return 4;case 'mousemove':return 64;case 'mouseout':return 32;case 'mouseover':return 16;case 'mouseup':return 8;case 'scroll':return 16384;case 'error':return 65536;case 'mousewheel':return 131072;case 'DOMMouseScroll':return 131072;}}
function gj(d,a,b){var c=a[b];return c==null?null:String(c);}
function fj(d,a,c){var b=parseInt(a[c]);if(!b){return 0;}return b;}
function hj(b,a){return a.__eventBits||0;}
function ij(e,d,b,f,a){var c=new Option(b,f);if(a== -1||a>d.options.length-1){d.add(c,null);}else{d.add(c,d.options[a]);}}
function jj(c,b,a){b.removeChild(a);}
function mj(c,a,b,d){a[b]=d;}
function kj(c,a,b,d){a[b]=d;}
function lj(c,a,b,d){a[b]=d;}
function nj(c,a,b){a.__listener=b;}
function oj(c,a,b){if(!b){b='';}a.innerHTML=b;}
function pj(c,a,b){while(a.firstChild){a.removeChild(a.firstChild);}if(b!=null){a.appendChild($doc.createTextNode(b));}}
function qj(c,b,a,d){b.style[a]=d;}
function rj(a){return $doc.body.clientHeight;}
function sj(a){return $doc.body.clientWidth;}
function ki(){}
_=ki.prototype=new vv();_.tN=mC+'DOMImpl';_.tI=0;function wi(b,a){a.preventDefault();}
function xi(c,a){var b=a.parentNode;if(b==null){return null;}if(b.nodeType!=1)b=null;return b||null;}
function yi(d){$wnd.__dispatchCapturedMouseEvent=function(b){if($wnd.__dispatchCapturedEvent(b)){var a=$wnd.__captureElem;if(a&&a.__listener){Af(b,a,a.__listener);b.stopPropagation();}}};$wnd.__dispatchCapturedEvent=function(a){if(!jg(a)){a.stopPropagation();a.preventDefault();return false;}return true;};$wnd.addEventListener('click',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('dblclick',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousedown',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mouseup',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousemove',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousewheel',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('keydown',$wnd.__dispatchCapturedEvent,true);$wnd.addEventListener('keyup',$wnd.__dispatchCapturedEvent,true);$wnd.addEventListener('keypress',$wnd.__dispatchCapturedEvent,true);$wnd.__dispatchEvent=function(b){var c,a=this;while(a&& !(c=a.__listener))a=a.parentNode;if(a&&a.nodeType!=1)a=null;if(c)Af(b,a,c);};$wnd.__captureElem=null;}
function zi(c,b,a){b.__eventBits=a;b.onclick=a&1?$wnd.__dispatchEvent:null;b.ondblclick=a&2?$wnd.__dispatchEvent:null;b.onmousedown=a&4?$wnd.__dispatchEvent:null;b.onmouseup=a&8?$wnd.__dispatchEvent:null;b.onmouseover=a&16?$wnd.__dispatchEvent:null;b.onmouseout=a&32?$wnd.__dispatchEvent:null;b.onmousemove=a&64?$wnd.__dispatchEvent:null;b.onkeydown=a&128?$wnd.__dispatchEvent:null;b.onkeypress=a&256?$wnd.__dispatchEvent:null;b.onkeyup=a&512?$wnd.__dispatchEvent:null;b.onchange=a&1024?$wnd.__dispatchEvent:null;b.onfocus=a&2048?$wnd.__dispatchEvent:null;b.onblur=a&4096?$wnd.__dispatchEvent:null;b.onlosecapture=a&8192?$wnd.__dispatchEvent:null;b.onscroll=a&16384?$wnd.__dispatchEvent:null;b.onload=a&32768?$wnd.__dispatchEvent:null;b.onerror=a&65536?$wnd.__dispatchEvent:null;b.onmousewheel=a&131072?$wnd.__dispatchEvent:null;}
function ui(){}
_=ui.prototype=new ki();_.tN=mC+'DOMImplStandard';_.tI=0;function pi(c,a,b){if(!a&& !b){return true;}else if(!a|| !b){return false;}return a.isSameNode(b);}
function ri(a){yi(a);qi(a);}
function qi(d){$wnd.addEventListener('mouseout',function(b){var a=$wnd.__captureElem;if(a&& !b.relatedTarget){if('html'==b.target.tagName.toLowerCase()){var c=$doc.createEvent('MouseEvents');c.initMouseEvent('mouseup',true,true,$wnd,0,b.screenX,b.screenY,b.clientX,b.clientY,b.ctrlKey,b.altKey,b.shiftKey,b.metaKey,b.button,null);a.dispatchEvent(c);}}},true);$wnd.addEventListener('DOMMouseScroll',$wnd.__dispatchCapturedMouseEvent,true);}
function ti(c,b,a){zi(c,b,a);si(c,b,a);}
function si(c,b,a){if(a&131072){b.addEventListener('DOMMouseScroll',$wnd.__dispatchEvent,false);}}
function li(){}
_=li.prototype=new ui();_.tN=mC+'DOMImplMozilla';_.tI=0;function mi(){}
_=mi.prototype=new li();_.tN=mC+'DOMImplMozillaOld';_.tI=0;function uj(a){Aj=jd();return a;}
function wj(c,d,b,a){return xj(c,null,null,d,b,a);}
function xj(d,f,c,e,b,a){return vj(d,f,c,e,b,a);}
function vj(e,g,d,f,c,b){var h=e.t();try{h.open('POST',f,true);h.setRequestHeader('Content-Type','text/plain; charset=utf-8');h.onreadystatechange=function(){if(h.readyState==4){h.onreadystatechange=Aj;b.hb(h.responseText||'');}};h.send(c);return true;}catch(a){h.onreadystatechange=Aj;return false;}}
function zj(){return new XMLHttpRequest();}
function tj(){}
_=tj.prototype=new vv();_.t=zj;_.tN=mC+'HTTPRequestImpl';_.tI=0;var Aj=null;function Dj(a){Av(a,'This application is out of date, please click the refresh button on your browser');return a;}
function Cj(){}
_=Cj.prototype=new zv();_.tN=nC+'IncompatibleRemoteServiceException';_.tI=22;function bk(b,a){}
function ck(b,a){}
function ek(b,a){Bv(b,a,null);return b;}
function dk(){}
_=dk.prototype=new zv();_.tN=nC+'InvocationException';_.tI=23;function ik(b,a){mu(b,a);return b;}
function hk(){}
_=hk.prototype=new lu();_.tN=nC+'SerializationException';_.tI=24;function nk(a){ek(a,'Service implementation URL not specified');return a;}
function mk(){}
_=mk.prototype=new dk();_.tN=nC+'ServiceDefTarget$NoServiceEntryPointSpecifiedException';_.tI=25;function sk(b,a){}
function tk(a){return zu(new yu(),a.rb());}
function uk(b,a){b.Db(a.a);}
function xk(b,a){}
function yk(a){return a.tb();}
function zk(b,a){b.Fb(a);}
function Ck(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();jz(b,c);}}
function Dk(e,a){var b,c,d;d=a.b;e.Db(d);b=a.ab();while(b.F()){c=b.cb();e.Eb(c);}}
function al(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();CB(b,c);}}
function bl(e,a){var b,c,d;d=a.a.b;e.Db(d);b=EB(a);while(b.F()){c=b.cb();e.Eb(c);}}
function vl(a){return a.j>2;}
function wl(b,a){b.i=a;}
function xl(a,b){a.j=b;}
function cl(){}
_=cl.prototype=new vv();_.tN=qC+'AbstractSerializationStream';_.tI=0;_.i=0;_.j=3;function el(a){a.e=hz(new fz());}
function fl(a){el(a);return a;}
function hl(b,a){lz(b.e);xl(b,Dl(b));wl(b,Dl(b));}
function il(a){var b,c;b=a.rb();if(b<0){return oz(a.e,-(b+1));}c=a.B(b);if(c===null){return null;}return a.r(c);}
function jl(b,a){jz(b.e,a);}
function kl(){return il(this);}
function dl(){}
_=dl.prototype=new cl();_.sb=kl;_.tN=qC+'AbstractSerializationStreamReader';_.tI=0;function nl(b,a){b.o(xw(a));}
function ol(c,a){var b,d;if(a===null){pl(c,null);return;}b=c.y(a);if(b>=0){nl(c,-(b+1));return;}c.yb(a);d=c.A(a);pl(c,d);c.zb(a,d);}
function pl(a,b){nl(a,a.l(b));}
function ql(a){this.o(ww(a));}
function rl(a){nl(this,a);}
function sl(a){ol(this,a);}
function tl(a){pl(this,a);}
function ll(){}
_=ll.prototype=new cl();_.Cb=ql;_.Db=rl;_.Eb=sl;_.Fb=tl;_.tN=qC+'AbstractSerializationStreamWriter';_.tI=0;function zl(b,a){fl(b);b.c=a;return b;}
function Bl(b,a){if(!a){return null;}return b.d[a-1];}
function Cl(b,a){b.b=am(a);b.a=bm(b.b);hl(b,a);b.d=El(b);}
function Dl(a){return a.b[--a.a];}
function El(a){return a.b[--a.a];}
function Fl(b){var a;a=jc(this.c,this,b);jl(this,a);hc(this.c,this,a,b);return a;}
function am(a){return eval(a);}
function bm(a){return a.length;}
function cm(a){return Bl(this,a);}
function dm(){return this.b[--this.a];}
function em(){return Dl(this);}
function fm(){return Bl(this,Dl(this));}
function yl(){}
_=yl.prototype=new dl();_.r=Fl;_.B=cm;_.qb=dm;_.rb=em;_.tb=fm;_.tN=qC+'ClientSerializationStreamReader';_.tI=0;_.a=0;_.b=null;_.c=null;_.d=null;function hm(a){a.h=hz(new fz());}
function im(d,c,a,b){hm(d);d.f=c;d.b=a;d.e=b;return d;}
function km(c,a){var b=c.d[a];return b==null?-1:b;}
function lm(c,a){var b=c.g[':'+a];return b==null?0:b;}
function mm(a){a.c=0;a.d=kd();a.g=kd();lz(a.h);a.a=Fv(new Ev());if(vl(a)){pl(a,a.b);pl(a,a.e);}}
function nm(b,a,c){b.d[a]=c;}
function om(b,a,c){b.g[':'+a]=c;}
function pm(b){var a;a=Fv(new Ev());qm(b,a);sm(b,a);rm(b,a);return fw(a);}
function qm(b,a){um(a,xw(b.j));um(a,xw(b.i));}
function rm(b,a){bw(a,fw(b.a));}
function sm(d,a){var b,c;c=d.h.b;um(a,xw(c));for(b=0;b<c;++b){um(a,Bd(oz(d.h,b),1));}return a;}
function tm(b){var a;if(b===null){return 0;}a=lm(this,b);if(a>0){return a;}jz(this.h,b);a=this.h.b;om(this,b,a);return a;}
function um(a,b){bw(a,b);aw(a,65535);}
function vm(a){um(this.a,a);}
function wm(a){return km(this,Bw(a));}
function xm(a){var b,c;c=yc(a);b=ic(this.f,c);if(b!==null){c+='/'+b;}return c;}
function ym(a){nm(this,Bw(a),this.c++);}
function zm(a,b){kc(this.f,this,a,b);}
function gm(){}
_=gm.prototype=new ll();_.l=tm;_.o=vm;_.y=wm;_.A=xm;_.yb=ym;_.zb=zm;_.tN=qC+'ClientSerializationStreamWriter';_.tI=0;_.a=null;_.b=null;_.c=0;_.d=null;_.e=null;_.f=null;_.g=null;function as(b,a){bs(b,ds(b)+Ad(45)+a);}
function bs(b,a){os(b.i,a,true);}
function ds(a){return ms(a.i);}
function es(b,a){fs(b,ds(b)+Ad(45)+a);}
function fs(b,a){os(b.i,a,false);}
function gs(d,b,a){var c=b.parentNode;if(!c){return;}c.insertBefore(a,b);c.removeChild(b);}
function hs(b,a){if(b.i!==null){gs(b,b.i,a);}b.i=a;}
function is(b,a){ns(b.i,a);}
function js(a,b){tg(a.i,'width',b);}
function ks(b,a){ug(b.i,a|fg(b.i));}
function ls(a){return eg(a,'className');}
function ms(a){var b,c;b=ls(a);c=jw(b,32);if(c>=0){return pw(b,0,c);}return b;}
function ns(a,b){pg(a,'className',b);}
function os(c,j,a){var b,d,e,f,g,h,i;if(c===null){throw Av(new zv(),'Null widget handle. If you are creating a composite, ensure that initWidget() has been called.');}j=qw(j);if(mw(j)==0){throw qu(new pu(),'Style names cannot be empty');}i=ls(c);e=kw(i,j);while(e!=(-1)){if(e==0||hw(i,e-1)==32){f=e+mw(j);g=mw(i);if(f==g||f<g&&hw(i,f)==32){break;}}e=lw(i,j,e+1);}if(a){if(e==(-1)){if(mw(i)>0){i+=' ';}pg(c,'className',i+j);}}else{if(e!=(-1)){b=qw(pw(i,0,e));d=qw(ow(i,e+mw(j)));if(mw(b)==0){h=d;}else if(mw(d)==0){h=b;}else{h=b+' '+d;}pg(c,'className',h);}}}
function Fr(){}
_=Fr.prototype=new vv();_.tN=rC+'UIObject';_.tI=0;_.i=null;function jt(a){if(a.g){throw tu(new su(),"Should only call onAttach when the widget is detached from the browser's document");}a.g=true;qg(a.i,a);a.s();a.lb();}
function kt(a){if(!a.g){throw tu(new su(),"Should only call onDetach when the widget is attached to the browser's document");}try{a.mb();}finally{a.u();qg(a.i,null);a.g=false;}}
function lt(a){if(a.h!==null){a.h.wb(a);}else if(a.h!==null){throw tu(new su(),"This widget's parent does not implement HasWidgets");}}
function mt(b,a){if(b.g){qg(b.i,null);}hs(b,a);if(b.g){qg(a,b);}}
function nt(c,b){var a;a=c.h;if(b===null){if(a!==null&&a.g){kt(c);}c.h=null;}else{if(a!==null){throw tu(new su(),'Cannot set a new parent without first clearing the old parent');}c.h=b;if(b.g){jt(c);}}}
function ot(){}
function pt(){}
function qt(a){}
function rt(){}
function st(){}
function tt(a){mt(this,a);}
function ws(){}
_=ws.prototype=new Fr();_.s=ot;_.u=pt;_.eb=qt;_.lb=rt;_.mb=st;_.Ab=tt;_.tN=rC+'Widget';_.tI=26;_.g=false;_.h=null;function xq(b,a){nt(a,b);}
function zq(b,a){nt(a,null);}
function Aq(){var a,b;for(b=this.ab();Bs(b);){a=Cs(b);jt(a);}}
function Bq(){var a,b;for(b=this.ab();Bs(b);){a=Cs(b);kt(a);}}
function Cq(){}
function Dq(){}
function wq(){}
_=wq.prototype=new ws();_.s=Aq;_.u=Bq;_.lb=Cq;_.mb=Dq;_.tN=rC+'Panel';_.tI=27;function Dn(a){a.f=at(new xs(),a);}
function En(a){Dn(a);return a;}
function Fn(c,a,b){lt(a);bt(c.f,a);of(b,a.i);xq(c,a);}
function bo(b,c){var a;if(c.h!==b){return false;}zq(b,c);a=c.i;kg(gg(a),a);ht(b.f,c);return true;}
function co(){return ft(this.f);}
function eo(a){return bo(this,a);}
function Cn(){}
_=Cn.prototype=new wq();_.ab=co;_.wb=eo;_.tN=rC+'ComplexPanel';_.tI=28;function Cm(a){En(a);a.Ab(rf());tg(a.i,'position','relative');tg(a.i,'overflow','hidden');return a;}
function Dm(a,b){Fn(a,b,a.i);}
function Fm(a){tg(a,'left','');tg(a,'top','');tg(a,'position','');}
function an(b){var a;a=bo(this,b);if(a){Fm(b.i);}return a;}
function Bm(){}
_=Bm.prototype=new Cn();_.wb=an;_.tN=rC+'AbsolutePanel';_.tI=29;function ho(){ho=gC;Dt(),Ft;}
function go(b,a){Dt(),Ft;jo(b,a);return b;}
function io(b,a){switch(bg(a)){case 1:if(b.d!==null){An(b.d,b);}break;case 4096:case 2048:break;case 128:case 512:case 256:break;}}
function jo(b,a){mt(b,a);ks(b,7041);}
function ko(b,a){ng(b.i,'disabled',!a);}
function lo(a){if(this.d===null){this.d=yn(new xn());}jz(this.d,a);}
function mo(a){io(this,a);}
function no(a){jo(this,a);}
function fo(){}
_=fo.prototype=new ws();_.k=lo;_.eb=mo;_.Ab=no;_.tN=rC+'FocusWidget';_.tI=30;_.d=null;function en(){en=gC;Dt(),Ft;}
function dn(b,a){Dt(),Ft;go(b,a);return b;}
function fn(b,a){rg(b.i,a);}
function cn(){}
_=cn.prototype=new fo();_.tN=rC+'ButtonBase';_.tI=31;function jn(){jn=gC;Dt(),Ft;}
function gn(a){Dt(),Ft;dn(a,qf());kn(a.i);is(a,'gwt-Button');return a;}
function hn(b,a){Dt(),Ft;gn(b);fn(b,a);return b;}
function kn(b){jn();if(b.type=='submit'){try{b.setAttribute('type','button');}catch(a){}}}
function bn(){}
_=bn.prototype=new cn();_.tN=rC+'Button';_.tI=32;function mn(a){En(a);a.e=wf();a.d=tf();of(a.e,a.d);a.Ab(a.e);return a;}
function on(a,b){if(b.h!==a){return null;}return gg(b.i);}
function qn(c,d,a){var b;b=on(c,d);if(b!==null){pn(c,b,a);}}
function pn(c,b,a){pg(b,'align',a.a);}
function rn(c,b,a){tg(b,'verticalAlign',a.a);}
function ln(){}
_=ln.prototype=new Cn();_.tN=rC+'CellPanel';_.tI=33;_.d=null;_.e=null;function ex(d,a,b){var c;while(a.F()){c=a.cb();if(b===null?c===null:b.eQ(c)){return a;}}return null;}
function gx(a){throw bx(new ax(),'add');}
function hx(b){var a;a=ex(this,this.ab(),b);return a!==null;}
function dx(){}
_=dx.prototype=new vv();_.n=gx;_.q=hx;_.tN=uC+'AbstractCollection';_.tI=0;function rx(b,a){throw wu(new vu(),'Index: '+a+', Size: '+b.b);}
function sx(b,a){throw bx(new ax(),'add');}
function tx(a){this.m(this.Bb(),a);return true;}
function ux(e){var a,b,c,d,f;if(e===this){return true;}if(!Cd(e,2)){return false;}f=Bd(e,2);if(this.Bb()!=f.Bb()){return false;}c=this.ab();d=f.ab();while(c.F()){a=c.cb();b=d.cb();if(!(a===null?b===null:a.eQ(b))){return false;}}return true;}
function vx(){var a,b,c,d;c=1;a=31;b=this.ab();while(b.F()){d=b.cb();c=31*c+(d===null?0:d.hC());}return c;}
function wx(){return kx(new jx(),this);}
function xx(a){throw bx(new ax(),'remove');}
function ix(){}
_=ix.prototype=new dx();_.m=sx;_.n=tx;_.eQ=ux;_.hC=vx;_.ab=wx;_.vb=xx;_.tN=uC+'AbstractList';_.tI=34;function gz(a){{kz(a);}}
function hz(a){gz(a);return a;}
function iz(c,a,b){if(a<0||a>c.b){rx(c,a);}uz(c.a,a,b);++c.b;}
function jz(b,a){Dz(b.a,b.b++,a);return true;}
function lz(a){kz(a);}
function kz(a){a.a=id();a.b=0;}
function nz(b,a){return pz(b,a)!=(-1);}
function oz(b,a){if(a<0||a>=b.b){rx(b,a);}return zz(b.a,a);}
function pz(b,a){return qz(b,a,0);}
function qz(c,b,a){if(a<0){rx(c,a);}for(;a<c.b;++a){if(yz(b,zz(c.a,a))){return a;}}return (-1);}
function rz(a){return a.b==0;}
function sz(c,a){var b;b=oz(c,a);Bz(c.a,a,1);--c.b;return b;}
function tz(c,b){var a;a=pz(c,b);if(a==(-1)){return false;}sz(c,a);return true;}
function vz(a,b){iz(this,a,b);}
function wz(a){return jz(this,a);}
function uz(a,b,c){a.splice(b,0,c);}
function xz(a){return nz(this,a);}
function yz(a,b){return a===b||a!==null&&a.eQ(b);}
function Az(a){return oz(this,a);}
function zz(a,b){return a[b];}
function Cz(a){return sz(this,a);}
function Bz(a,c,b){a.splice(c,b);}
function Dz(a,b,c){a[b]=c;}
function Ez(){return this.b;}
function fz(){}
_=fz.prototype=new ix();_.m=vz;_.n=wz;_.q=xz;_.D=Az;_.vb=Cz;_.Bb=Ez;_.tN=uC+'ArrayList';_.tI=35;_.a=null;_.b=0;function tn(a){hz(a);return a;}
function vn(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),12);b.fb(c);}}
function sn(){}
_=sn.prototype=new fz();_.tN=rC+'ChangeListenerCollection';_.tI=36;function yn(a){hz(a);return a;}
function An(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),13);b.gb(c);}}
function xn(){}
_=xn.prototype=new fz();_.tN=rC+'ClickListenerCollection';_.tI=37;function Cp(a){a.Ab(rf());ks(a,131197);is(a,'gwt-Label');return a;}
function Dp(b,a){Cp(b);Fp(b,a);return b;}
function Fp(b,a){sg(b.i,a);}
function aq(a){switch(bg(a)){case 1:break;case 4:case 8:case 64:case 16:case 32:break;case 131072:break;}}
function Bp(){}
_=Bp.prototype=new ws();_.eb=aq;_.tN=rC+'Label';_.tI=38;function po(a){Cp(a);a.Ab(rf());ks(a,125);is(a,'gwt-HTML');return a;}
function qo(b,a){po(b);so(b,a);return b;}
function so(b,a){rg(b.i,a);}
function oo(){}
_=oo.prototype=new Bp();_.tN=rC+'HTML';_.tI=39;function zo(){zo=gC;xo(new wo(),'center');Ao=xo(new wo(),'left');Bo=xo(new wo(),'right');}
var Ao,Bo;function xo(b,a){b.a=a;return b;}
function wo(){}
_=wo.prototype=new vv();_.tN=rC+'HasHorizontalAlignment$HorizontalAlignmentConstant';_.tI=0;_.a=null;function bp(){bp=gC;Fo(new Eo(),'bottom');Fo(new Eo(),'middle');cp=Fo(new Eo(),'top');}
var cp;function Fo(a,b){a.a=b;return a;}
function Eo(){}
_=Eo.prototype=new vv();_.tN=rC+'HasVerticalAlignment$VerticalAlignmentConstant';_.tI=0;_.a=null;function gp(a){a.a=(zo(),Ao);a.c=(bp(),cp);}
function hp(a){mn(a);gp(a);a.b=vf();of(a.d,a.b);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function ip(b,c){var a;a=kp(b);of(b.b,a);Fn(b,c,a);}
function kp(b){var a;a=uf();pn(b,a,b.a);rn(b,a,b.c);return a;}
function lp(c){var a,b;b=gg(c.i);a=bo(this,c);if(a){kg(this.b,b);}return a;}
function fp(){}
_=fp.prototype=new ln();_.wb=lp;_.tN=rC+'HorizontalPanel';_.tI=40;_.b=null;function tp(a){hz(a);return a;}
function vp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.ib(e,b,d);}}
function wp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.jb(e,b,d);}}
function xp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.kb(e,b,d);}}
function yp(d,c,a){var b;b=zp(a);switch(bg(a)){case 128:vp(d,c,Dd(Ef(a)),b);break;case 512:xp(d,c,Dd(Ef(a)),b);break;case 256:wp(d,c,Dd(Ef(a)),b);break;}}
function zp(a){return (ag(a)?1:0)|(Ff(a)?8:0)|(Df(a)?2:0)|(Cf(a)?4:0);}
function sp(){}
_=sp.prototype=new fz();_.tN=rC+'KeyboardListenerCollection';_.tI=41;function lq(){lq=gC;Dt(),Ft;uq=new cq();}
function hq(a){lq();iq(a,false);return a;}
function iq(b,a){lq();go(b,sf(a));ks(b,1024);is(b,'gwt-ListBox');return b;}
function jq(b,a){pq(b,a,(-1));}
function kq(b,a){if(a<0||a>=mq(b)){throw new vu();}}
function mq(a){return eq(uq,a.i);}
function nq(a){return dg(a.i,'selectedIndex');}
function oq(b,a){kq(b,a);return fq(uq,b.i,a);}
function pq(c,b,a){qq(c,b,b,a);}
function qq(c,b,d,a){ig(c.i,b,d,a);}
function rq(c,a,b){kq(c,a);gq(uq,c.i,a,b);}
function sq(b,a){ng(b.i,'multiple',a);}
function tq(a,b){og(a.i,'size',b);}
function vq(a){if(bg(a)==1024){}else{io(this,a);}}
function bq(){}
_=bq.prototype=new fo();_.eb=vq;_.tN=rC+'ListBox';_.tI=42;var uq;function eq(b,a){return a.options.length;}
function fq(c,b,a){return b.options[a].value;}
function gq(d,b,a,c){b.options[a].selected=c;}
function cq(){}
_=cq.prototype=new vv();_.tN=rC+'ListBox$Impl';_.tI=0;function er(){er=gC;jr=BA(new bA());}
function dr(b,a){er();Cm(b);if(a===null){a=fr();}b.Ab(a);jt(b);return b;}
function gr(){er();return hr(null);}
function hr(c){er();var a,b;b=Bd(bB(jr,c),15);if(b!==null){return b;}a=null;if(jr.c==0){ir();}cB(jr,c,b=dr(new Eq(),a));return b;}
function fr(){er();return $doc.body;}
function ir(){er();Dh(new Fq());}
function Eq(){}
_=Eq.prototype=new Bm();_.tN=rC+'RootPanel';_.tI=43;var jr;function br(){var a,b;for(b=ly(Ay((er(),jr)));sy(b);){a=Bd(ty(b),15);if(a.g){kt(a);}}}
function cr(){return null;}
function Fq(){}
_=Fq.prototype=new vv();_.nb=br;_.ob=cr;_.tN=rC+'RootPanel$1';_.tI=44;function zr(){zr=gC;Dt(),Ft;}
function wr(b,a){Dt(),Ft;go(b,a);ks(b,1024);return b;}
function xr(b,a){if(b.a===null){b.a=tn(new sn());}jz(b.a,a);}
function yr(b,a){if(b.c===null){b.c=tp(new sp());}jz(b.c,a);}
function Ar(a){return eg(a.i,'value');}
function Br(c,a){var b;ng(c.i,'readOnly',a);b='readonly';if(a){as(c,b);}else{es(c,b);}}
function Cr(b,a){pg(b.i,'value',a!==null?a:'');}
function Dr(a){if(this.b===null){this.b=yn(new xn());}jz(this.b,a);}
function Er(a){var b;io(this,a);b=bg(a);if(this.c!==null&&(b&896)!=0){yp(this.c,this,a);}else if(b==1){if(this.b!==null){An(this.b,this);}}else if(b==1024){if(this.a!==null){vn(this.a,this);}}}
function vr(){}
_=vr.prototype=new fo();_.k=Dr;_.eb=Er;_.tN=rC+'TextBoxBase';_.tI=45;_.a=null;_.b=null;_.c=null;function sr(){sr=gC;Dt(),Ft;}
function rr(a){Dt(),Ft;wr(a,xf());is(a,'gwt-TextArea');return a;}
function tr(a,b){og(a.i,'cols',b);}
function ur(b,a){og(b.i,'rows',a);}
function qr(){}
_=qr.prototype=new vr();_.tN=rC+'TextArea';_.tI=46;function qs(a){a.a=(zo(),Ao);a.b=(bp(),cp);}
function rs(a){mn(a);qs(a);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function ss(b,d){var a,c;c=vf();a=us(b);of(c,a);of(b.d,c);Fn(b,d,a);}
function us(b){var a;a=uf();pn(b,a,b.a);rn(b,a,b.b);return a;}
function vs(c){var a,b;b=gg(c.i);a=bo(this,c);if(a){kg(this.d,gg(b));}return a;}
function ps(){}
_=ps.prototype=new ln();_.wb=vs;_.tN=rC+'VerticalPanel';_.tI=47;function at(b,a){b.b=a;b.a=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[4],null);return b;}
function bt(a,b){et(a,b,a.c);}
function dt(b,c){var a;for(a=0;a<b.c;++a){if(b.a[a]===c){return a;}}return (-1);}
function et(d,e,a){var b,c;if(a<0||a>d.c){throw new vu();}if(d.c==d.a.a){c=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[d.a.a*2],null);for(b=0;b<d.a.a;++b){wd(c,b,d.a[b]);}d.a=c;}++d.c;for(b=d.c-1;b>a;--b){wd(d.a,b,d.a[b-1]);}wd(d.a,a,e);}
function ft(a){return zs(new ys(),a);}
function gt(c,b){var a;if(b<0||b>=c.c){throw new vu();}--c.c;for(a=b;a<c.c;++a){wd(c.a,a,c.a[a+1]);}wd(c.a,c.c,null);}
function ht(b,c){var a;a=dt(b,c);if(a==(-1)){throw new wB();}gt(b,a);}
function xs(){}
_=xs.prototype=new vv();_.tN=rC+'WidgetCollection';_.tI=0;_.a=null;_.b=null;_.c=0;function zs(b,a){b.b=a;return b;}
function Bs(a){return a.a<a.b.c-1;}
function Cs(a){if(a.a>=a.b.c){throw new wB();}return a.b.a[++a.a];}
function Ds(){return Bs(this);}
function Es(){return Cs(this);}
function Fs(){if(this.a<0||this.a>=this.b.c){throw new su();}this.b.b.wb(this.b.a[this.a--]);}
function ys(){}
_=ys.prototype=new vv();_.F=Ds;_.cb=Es;_.ub=Fs;_.tN=rC+'WidgetCollection$WidgetIterator';_.tI=0;_.a=(-1);function Dt(){Dt=gC;Et=xt(new vt());Ft=Et!==null?Ct(new ut()):Et;}
function Ct(a){Dt();return a;}
function ut(){}
_=ut.prototype=new vv();_.tN=sC+'FocusImpl';_.tI=0;var Et,Ft;function yt(){yt=gC;Dt();}
function wt(a){zt(a);At(a);Bt(a);}
function xt(a){yt();Ct(a);wt(a);return a;}
function zt(b){return function(a){if(this.parentNode.onblur){this.parentNode.onblur(a);}};}
function At(b){return function(a){if(this.parentNode.onfocus){this.parentNode.onfocus(a);}};}
function Bt(a){return function(){this.firstChild.focus();};}
function vt(){}
_=vt.prototype=new ut();_.tN=sC+'FocusImplOld';_.tI=0;function bu(){}
_=bu.prototype=new zv();_.tN=tC+'ArrayStoreException';_.tI=48;function gu(a,b){if(b<2||b>36){return (-1);}if(a>=48&&a<48+ev(b,10)){return a-48;}if(a>=97&&a<b+97-10){return a-97+10;}if(a>=65&&a<b+65-10){return a-65+10;}return (-1);}
function hu(){}
_=hu.prototype=new zv();_.tN=tC+'ClassCastException';_.tI=49;function qu(b,a){Av(b,a);return b;}
function pu(){}
_=pu.prototype=new zv();_.tN=tC+'IllegalArgumentException';_.tI=50;function tu(b,a){Av(b,a);return b;}
function su(){}
_=su.prototype=new zv();_.tN=tC+'IllegalStateException';_.tI=51;function wu(b,a){Av(b,a);return b;}
function vu(){}
_=vu.prototype=new zv();_.tN=tC+'IndexOutOfBoundsException';_.tI=52;function pv(){pv=gC;{uv();}}
function ov(a){pv();return a;}
function qv(a){pv();return isNaN(a);}
function rv(e,d,c,h){pv();var a,b,f,g;if(e===null){throw mv(new lv(),'Unable to parse null');}b=mw(e);f=b>0&&hw(e,0)==45?1:0;for(a=f;a<b;a++){if(gu(hw(e,a),d)==(-1)){throw mv(new lv(),'Could not parse '+e+' in radix '+d);}}g=sv(e,d);if(qv(g)){throw mv(new lv(),'Unable to parse '+e);}else if(g<c||g>h){throw mv(new lv(),'The string '+e+' exceeds the range for the requested data type');}return g;}
function sv(b,a){pv();return parseInt(b,a);}
function uv(){pv();tv=/^[+-]?\d*\.?\d*(e[+-]?\d+)?$/i;}
function kv(){}
_=kv.prototype=new vv();_.tN=tC+'Number';_.tI=0;var tv=null;function Au(){Au=gC;pv();}
function zu(a,b){Au();ov(a);a.a=b;return a;}
function Bu(a){return Cd(a,20)&&Bd(a,20).a==this.a;}
function Cu(){return this.a;}
function Du(a){Au();return Eu(a,10);}
function Eu(b,a){Au();return Ed(rv(b,a,(-2147483648),2147483647));}
function Fu(a){Au();return xw(a);}
function av(a){Au();return zu(new yu(),Du(a));}
function yu(){}
_=yu.prototype=new kv();_.eQ=Bu;_.hC=Cu;_.tN=tC+'Integer';_.tI=53;_.a=0;function dv(a){return a<0?-a:a;}
function ev(a,b){return a<b?a:b;}
function fv(){}
_=fv.prototype=new zv();_.tN=tC+'NegativeArraySizeException';_.tI=54;function iv(b,a){Av(b,a);return b;}
function hv(){}
_=hv.prototype=new zv();_.tN=tC+'NullPointerException';_.tI=55;function mv(b,a){qu(b,a);return b;}
function lv(){}
_=lv.prototype=new pu();_.tN=tC+'NumberFormatException';_.tI=56;function hw(b,a){return b.charCodeAt(a);}
function jw(b,a){return b.indexOf(String.fromCharCode(a));}
function kw(b,a){return b.indexOf(a);}
function lw(c,b,a){return c.indexOf(b,a);}
function mw(a){return a.length;}
function nw(b,a){return kw(b,a)==0;}
function ow(b,a){return b.substr(a,b.length-a);}
function pw(c,a,b){return c.substr(a,b-a);}
function qw(c){var a=c.replace(/^(\s*)/,'');var b=a.replace(/\s*$/,'');return b;}
function rw(a,b){return String(a)==b;}
function sw(a){if(!Cd(a,1))return false;return rw(this,a);}
function uw(){var a=tw;if(!a){a=tw={};}var e=':'+this;var b=a[e];if(b==null){b=0;var f=this.length;var d=f<64?1:f/32|0;for(var c=0;c<f;c+=d){b<<=1;b+=this.charCodeAt(c);}b|=0;a[e]=b;}return b;}
function vw(a){return String.fromCharCode(a);}
function ww(a){return ''+a;}
function xw(a){return ''+a;}
_=String.prototype;_.eQ=sw;_.hC=uw;_.tN=tC+'String';_.tI=2;var tw=null;function Fv(a){cw(a);return a;}
function aw(a,b){return bw(a,vw(b));}
function bw(c,d){if(d===null){d='null';}var a=c.js.length-1;var b=c.js[a].length;if(c.length>b*b){c.js[a]=c.js[a]+d;}else{c.js.push(d);}c.length+=d.length;return c;}
function cw(a){dw(a,'');}
function dw(b,a){b.js=[a];b.length=a.length;}
function fw(a){a.db();return a.js[0];}
function gw(){if(this.js.length>1){this.js=[this.js.join('')];this.length=this.js[0].length;}}
function Ev(){}
_=Ev.prototype=new vv();_.db=gw;_.tN=tC+'StringBuffer';_.tI=0;function Aw(){return new Date().getTime();}
function Bw(a){return Dc(a);}
function bx(b,a){Av(b,a);return b;}
function ax(){}
_=ax.prototype=new zv();_.tN=tC+'UnsupportedOperationException';_.tI=57;function kx(b,a){b.c=a;return b;}
function mx(a){return a.a<a.c.Bb();}
function nx(){return mx(this);}
function ox(){if(!mx(this)){throw new wB();}return this.c.D(this.b=this.a++);}
function px(){if(this.b<0){throw new su();}this.c.vb(this.b);this.a=this.b;this.b=(-1);}
function jx(){}
_=jx.prototype=new vv();_.F=nx;_.cb=ox;_.ub=px;_.tN=uC+'AbstractList$IteratorImpl';_.tI=0;_.a=0;_.b=(-1);function yy(f,d,e){var a,b,c;for(b=wA(f.v());oA(b);){a=pA(b);c=a.z();if(d===null?c===null:d.eQ(c)){if(e){qA(b);}return a;}}return null;}
function zy(b){var a;a=b.v();return Ax(new zx(),b,a);}
function Ay(b){var a;a=aB(b);return jy(new iy(),b,a);}
function By(a){return yy(this,a,false)!==null;}
function Cy(d){var a,b,c,e,f,g,h;if(d===this){return true;}if(!Cd(d,21)){return false;}f=Bd(d,21);c=zy(this);e=f.bb();if(!cz(c,e)){return false;}for(a=Cx(c);dy(a);){b=ey(a);h=this.E(b);g=f.E(b);if(h===null?g!==null:!h.eQ(g)){return false;}}return true;}
function Dy(b){var a;a=yy(this,b,false);return a===null?null:a.C();}
function Ey(){var a,b,c;b=0;for(c=wA(this.v());oA(c);){a=pA(c);b+=a.hC();}return b;}
function Fy(){return zy(this);}
function yx(){}
_=yx.prototype=new vv();_.p=By;_.eQ=Cy;_.E=Dy;_.hC=Ey;_.bb=Fy;_.tN=uC+'AbstractMap';_.tI=58;function cz(e,b){var a,c,d;if(b===e){return true;}if(!Cd(b,22)){return false;}c=Bd(b,22);if(c.Bb()!=e.Bb()){return false;}for(a=c.ab();a.F();){d=a.cb();if(!e.q(d)){return false;}}return true;}
function dz(a){return cz(this,a);}
function ez(){var a,b,c;a=0;for(b=this.ab();b.F();){c=b.cb();if(c!==null){a+=c.hC();}}return a;}
function az(){}
_=az.prototype=new dx();_.eQ=dz;_.hC=ez;_.tN=uC+'AbstractSet';_.tI=59;function Ax(b,a,c){b.a=a;b.b=c;return b;}
function Cx(b){var a;a=wA(b.b);return by(new ay(),b,a);}
function Dx(a){return this.a.p(a);}
function Ex(){return Cx(this);}
function Fx(){return this.b.a.c;}
function zx(){}
_=zx.prototype=new az();_.q=Dx;_.ab=Ex;_.Bb=Fx;_.tN=uC+'AbstractMap$1';_.tI=60;function by(b,a,c){b.a=c;return b;}
function dy(a){return oA(a.a);}
function ey(b){var a;a=pA(b.a);return a.z();}
function fy(){return dy(this);}
function gy(){return ey(this);}
function hy(){qA(this.a);}
function ay(){}
_=ay.prototype=new vv();_.F=fy;_.cb=gy;_.ub=hy;_.tN=uC+'AbstractMap$2';_.tI=0;function jy(b,a,c){b.a=a;b.b=c;return b;}
function ly(b){var a;a=wA(b.b);return qy(new py(),b,a);}
function my(a){return FA(this.a,a);}
function ny(){return ly(this);}
function oy(){return this.b.a.c;}
function iy(){}
_=iy.prototype=new dx();_.q=my;_.ab=ny;_.Bb=oy;_.tN=uC+'AbstractMap$3';_.tI=0;function qy(b,a,c){b.a=c;return b;}
function sy(a){return oA(a.a);}
function ty(a){var b;b=pA(a.a).C();return b;}
function uy(){return sy(this);}
function vy(){return ty(this);}
function wy(){qA(this.a);}
function py(){}
_=py.prototype=new vv();_.F=uy;_.cb=vy;_.ub=wy;_.tN=uC+'AbstractMap$4';_.tI=0;function DA(){DA=gC;eB=kB();}
function AA(a){{CA(a);}}
function BA(a){DA();AA(a);return a;}
function CA(a){a.a=id();a.d=kd();a.b=ce(eB,ed);a.c=0;}
function EA(b,a){if(Cd(a,1)){return oB(b.d,Bd(a,1))!==eB;}else if(a===null){return b.b!==eB;}else{return nB(b.a,a,a.hC())!==eB;}}
function FA(a,b){if(a.b!==eB&&mB(a.b,b)){return true;}else if(jB(a.d,b)){return true;}else if(hB(a.a,b)){return true;}return false;}
function aB(a){return uA(new kA(),a);}
function bB(c,a){var b;if(Cd(a,1)){b=oB(c.d,Bd(a,1));}else if(a===null){b=c.b;}else{b=nB(c.a,a,a.hC());}return b===eB?null:b;}
function cB(c,a,d){var b;{b=c.b;c.b=d;}if(b===eB){++c.c;return null;}else{return b;}}
function dB(c,a){var b;if(Cd(a,1)){b=rB(c.d,Bd(a,1));}else if(a===null){b=c.b;c.b=ce(eB,ed);}else{b=qB(c.a,a,a.hC());}if(b===eB){return null;}else{--c.c;return b;}}
function fB(e,c){DA();for(var d in e){if(d==parseInt(d)){var a=e[d];for(var f=0,b=a.length;f<b;++f){c.n(a[f]);}}}}
function gB(d,a){DA();for(var c in d){if(c.charCodeAt(0)==58){var e=d[c];var b=fA(c.substring(1),e);a.n(b);}}}
function hB(f,h){DA();for(var e in f){if(e==parseInt(e)){var a=f[e];for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.C();if(mB(h,d)){return true;}}}}return false;}
function iB(a){return EA(this,a);}
function jB(c,d){DA();for(var b in c){if(b.charCodeAt(0)==58){var a=c[b];if(mB(d,a)){return true;}}}return false;}
function kB(){DA();}
function lB(){return aB(this);}
function mB(a,b){DA();if(a===b){return true;}else if(a===null){return false;}else{return a.eQ(b);}}
function pB(a){return bB(this,a);}
function nB(f,h,e){DA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(mB(h,d)){return c.C();}}}}
function oB(b,a){DA();return b[':'+a];}
function qB(f,h,e){DA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(mB(h,d)){if(a.length==1){delete f[e];}else{a.splice(g,1);}return c.C();}}}}
function rB(c,a){DA();a=':'+a;var b=c[a];delete c[a];return b;}
function bA(){}
_=bA.prototype=new yx();_.p=iB;_.v=lB;_.E=pB;_.tN=uC+'HashMap';_.tI=61;_.a=null;_.b=null;_.c=0;_.d=null;var eB;function dA(b,a,c){b.a=a;b.b=c;return b;}
function fA(a,b){return dA(new cA(),a,b);}
function gA(b){var a;if(Cd(b,23)){a=Bd(b,23);if(mB(this.a,a.z())&&mB(this.b,a.C())){return true;}}return false;}
function hA(){return this.a;}
function iA(){return this.b;}
function jA(){var a,b;a=0;b=0;if(this.a!==null){a=this.a.hC();}if(this.b!==null){b=this.b.hC();}return a^b;}
function cA(){}
_=cA.prototype=new vv();_.eQ=gA;_.z=hA;_.C=iA;_.hC=jA;_.tN=uC+'HashMap$EntryImpl';_.tI=62;_.a=null;_.b=null;function uA(b,a){b.a=a;return b;}
function wA(a){return mA(new lA(),a.a);}
function xA(c){var a,b,d;if(Cd(c,23)){a=Bd(c,23);b=a.z();if(EA(this.a,b)){d=bB(this.a,b);return mB(a.C(),d);}}return false;}
function yA(){return wA(this);}
function zA(){return this.a.c;}
function kA(){}
_=kA.prototype=new az();_.q=xA;_.ab=yA;_.Bb=zA;_.tN=uC+'HashMap$EntrySet';_.tI=63;function mA(c,b){var a;c.c=b;a=hz(new fz());if(c.c.b!==(DA(),eB)){jz(a,dA(new cA(),null,c.c.b));}gB(c.c.d,a);fB(c.c.a,a);c.a=a.ab();return c;}
function oA(a){return a.a.F();}
function pA(a){return a.b=Bd(a.a.cb(),23);}
function qA(a){if(a.b===null){throw tu(new su(),'Must call next() before remove().');}else{a.a.ub();dB(a.c,a.b.z());a.b=null;}}
function rA(){return oA(this);}
function sA(){return pA(this);}
function tA(){qA(this);}
function lA(){}
_=lA.prototype=new vv();_.F=rA;_.cb=sA;_.ub=tA;_.tN=uC+'HashMap$EntrySetIterator';_.tI=0;_.a=null;_.b=null;function wB(){}
_=wB.prototype=new zv();_.tN=uC+'NoSuchElementException';_.tI=64;function BB(a){a.a=hz(new fz());return a;}
function CB(b,a){return jz(b.a,a);}
function EB(a){return a.a.ab();}
function FB(a,b){iz(this.a,a,b);}
function aC(a){return CB(this,a);}
function bC(a){return nz(this.a,a);}
function cC(a){return oz(this.a,a);}
function dC(){return EB(this);}
function eC(a){return sz(this.a,a);}
function fC(){return this.a.b;}
function AB(){}
_=AB.prototype=new ix();_.m=FB;_.n=aC;_.q=bC;_.D=cC;_.ab=dC;_.vb=eC;_.Bb=fC;_.tN=uC+'Vector';_.tI=65;_.a=null;function au(){vb(new ab());}
function gwtOnLoad(b,d,c){$moduleName=d;$moduleBase=c;if(b)try{au();}catch(a){b(d);}else{au();}}
var be=[{},{},{1:1},{3:1},{11:1},{7:1},{12:1},{14:1},{14:1},{13:1},{5:1},{5:1},{5:1},{5:1},{6:1},{5:1},{9:1},{9:1},{9:1},{6:1,8:1},{6:1},{10:1},{5:1},{5:1},{4:1,5:1},{5:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{2:1},{2:1},{2:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{16:1,17:1,18:1,19:1},{15:1,16:1,17:1,18:1,19:1},{10:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{5:1},{5:1},{5:1},{5:1},{5:1},{20:1},{5:1},{5:1},{5:1},{5:1},{21:1},{22:1},{22:1},{21:1},{23:1},{22:1},{5:1},{2:1}];if (TFDSSummarizer) {  var __gwt_initHandlers = TFDSSummarizer.__gwt_initHandlers;  TFDSSummarizer.onScriptLoad(gwtOnLoad);}})();