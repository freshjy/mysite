desc user;

-- 전체회원 보기: select
select *
	from user;

-- 회원가입 : insert
insert	
	into user	
values(null, '백정엽', 'qorwjdduq@gmail.com', '1234','male', now());

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
