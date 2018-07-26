insert into member values('881011kim','1234','김동현','721012-1111111','1990/11/11','1','1','과장','팀장','4급20호봉','2010/10/01',null,'d006','재직','222-222','서울시 봉천구','좋은동네','02-858-1111','02-858-1111','010-111-4444','jang@naver.com','kimdong.jpg');
insert into member values('787871lee','1234','이민호','721012-1111111','1990/11/11','1','1','대리','사원','4급20호봉','2010/10/01',null,'dg001','재직','222-222','서울시 봉천구','좋은동네','02-858-1111','02-858-1111','010-111-4444','jang@naver.com','leemin.jpg');
insert into member values('17171park','1234','박문수','721012-1111111','1990/11/11','1','1','대리','사원','4급20호봉','2010/10/01',null,'d0032','재직','222-222','서울시 봉천구','좋은동네','02-858-1111','02-858-1111','010-111-4444','jang@naver.com','park.jpg');
insert into member values('9871kim','1234','김어준','721012-1111111','1990/11/11','1','1','과장','팀장','4급20호봉','2010/10/01',null,'d009','재직','222-222','서울시 봉천구','좋은동네','02-858-1111','02-858-1111','010-111-4444','jang@naver.com','jjangkim.jpg');
insert into member values('lee0idjj','1234','안정환','721012-1111111','1990/11/11','1','1','차장','팀장','4급20호봉','2010/10/01',null,'dg002','재직','222-222','서울시 봉천구','좋은동네','02-858-1111','02-858-1111','010-111-4444','jang@naver.com','ansoccer.jpg');
insert into member values('djdiwjs','1234','차범근','721012-1111111','1990/11/11','1','1','사원','사원','4급20호봉','2010/10/01',null,'dg003','재직','222-222','서울시 봉천구','좋은동네','02-858-1111','02-858-1111','010-111-4444','jang@naver.com','chasoccer.jpg');
insert into member values('282djdid','1234','박지성','721012-1111111','1990/11/11','1','1','대리','파트장','4급20호봉','2010/10/01',null,'d001','재직','222-222','서울시 봉천구','좋은동네','02-858-1111','02-858-1111','010-111-4444','jang@naver.com','parksoccer.jpg');
insert into member values('Yeona1231','1234','김연아','721012-1111111','1990/11/11','1','1','대리','파트장','4급20호봉','2010/10/01',null,'d003','재직','222-222','서울시 봉천구','좋은동네','02-858-1111','02-858-1111','010-111-4444','jang@naver.com','parksoccer.jpg');


create sequence purchase_seq;
create sequence purchase_detail_seq;

drop sequence purchase_seq;
drop sequence purchase_detail_seq;
drop table purchase
drop table purchase_detail

#구매일반
create table purchase(
	purchase_id varchar2(20) primary key,
	purchase_day date,
	request_id varchar2(15),
	request_dept varchar2(20),
	request_deptno varchar2(20),
	state char(1),
	type varchar2(15)
)

#구매상세
create table purchase_detail(
    purchase_id varchar2(20),
	detail_num number,
	prd_code varchar2(15),
	prd_name varchar2(15),
	standard varchar2(15),
	count number,
	price number,
	supplyvalue number,
	vat number,
	totalprice number,
	clientcode varchar2(20)
)

insert into purchase values(to_char(sysdate,'yyyymmdd')|| purchase_seq.nextval, sysdate,'787871lee', '경영지원본부','0','사내행사용');
insert into purchase_detail values(to_char(sysdate,'yyyymmdd')||purchase_seq.currval,purchase_detail_seq.nextval,'prd_002','현수막','4*10',2,100000,200000,20000,220000,'code001');
insert into purchase_detail values(to_char(sysdate,'yyyymmdd')||purchase_seq.currval,purchase_detail_seq.nextval,'prd_003','의자','',20,5000,100000,10000,110000,'code010');
insert into purchase_detail values(to_char(sysdate,'yyyymmdd')||purchase_seq.currval,purchase_detail_seq.nextval,'prd_010','탁자','5*10',1,100000,100000,10000,110000,'code0002');


insert into purchase values(to_char(sysdate,'yyyymmdd')|| purchase_seq.nextval, sysdate,'Yeona1231', '개발팀','0','개발용');
insert into purchase_detail values(to_char(sysdate,'yyyymmdd')||purchase_seq.currval,purchase_detail_seq.nextval,'prd_00i2','노트북','18인치',5,865000,4325000,432500,4757500,'com001');
insert into purchase_detail values(to_char(sysdate,'yyyymmdd')||purchase_seq.currval,purchase_detail_seq.nextval,'prd_00i3','오피스','ver2016',10,30000,300000,30000,330000,'soft010');
insert into purchase_detail values(to_char(sysdate,'yyyymmdd')||purchase_seq.currval,purchase_detail_seq.nextval,'prd_0i10','펜마우스','11t',1,100000,100000,10000,110000,'pen0002');

select * from member;

select * from purchase;
select * from purchase_detail;

select rownum, p.*
from (select  * from purchase
	  where state ='0' 
      order by purchase_day desc) p
where rownum=1








