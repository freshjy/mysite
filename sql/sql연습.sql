desc user;

-- 전체회원 보기: select
select *
	from user;
delete from user where no = 16;
-- 회원가입 : insert
insert	
	into user	
values(null, '백정엽1', 'qorwjdduq@gmail.com', '1234','male', now());

-- 로그인  : select
select no,name	
	from user	
where email = 'qorwjdduq@gmail.com'	
	and password='1234';
    
-- 회원정보 보기 및 수정
select no, name, email, gender, date_format(join_data, '%Y-%m-%d')	
	from user
where no=1;

-- 회원정보 수정 : update
-- update user
--- set
-- where no=1;

select * from user;

alter table user add column role enum("USER", "ADMIN") default "USER" after gender;

insert into user values(null, '관리자', 'admin@mysite.com', '1234', 'male', 'ADMIN', now());