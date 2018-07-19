#부서 테이블
drop table dept CASCADE CONSTRAINTS;
create table dept{
	deptno varchar2(15) primary key,
	deptname varchar2(15),
	deptStartDay date,
	deptEndDay date,
	deptlevel varchar2(5),
	deptstep varchar2(5),
	deptuppercode varchar2(15),
	job_category varchar2(15),
	mgr_id varchar2(15),
	deptaddr varchar2(50),
	depttel varchar2(15),
}
#인사 테이블
drop table member CASCADE CONSTRAINTS;
create table member(
	id varchar2(20) primary key,
	name varchar2(15),
	ssn varchar2(15),
	birthday date,
	marry char(1),
	gender char(1),
	position varchar2(15),
	duty varchar2(15),
	classes varchar2(15),
	startday date,
	endday date,
	deptno varchar2(15),
	curstate varchar2(10),
	zipcode varchar2(10),
	addr varchar2(80),
	detailaddr varchar2(50),
	phonehome varchar2(15),
	phoneco varchar2(15),
	phonecell varchar2(15),
	email varchar2(50),
	profile_photo varchar2(50))

#업무테이블
drop table job CASCADE CONSTRAINTS;
create table job(
	job_id varchar2(10) primary key,
	job_name varchar2(15),
	job_category varchar2(15),
	menupath varchar2(50))

#제약조건
alter table member
add constraint member_fk foreign key(deptno) references dept(deptno)


alter table dept
add constraint dept_fk foreign key(mgr_id) references member(id)

alter table dept
add constraint job_fk foreign key(job_category) references job(job_category)

#데이터

insert into dept values('d001','인사팀','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d002','재무팀','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d003','개발팀','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d004','개발지원','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d005','시스템지원팀','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d006','총무과','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('dg001','경영지원본부','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('dg002','영업본부','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('dg003','IT지원센터','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d007','교육부','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d008','기획실','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d009','영업1팀','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d010','기업영업본부','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d011','영업2팀','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');
insert into dept values('d012','마케팅실','1999/9/27',null,'2','1','dg001','j001','9401023jang','서울시 서초구 kitri빌딩7층','02-225-1111');








