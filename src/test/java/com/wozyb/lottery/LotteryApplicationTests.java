package com.wozyb.lottery;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class LotteryApplicationTests {
	/*@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
	}

	*//*测试添加用户方法速度*//*
	@Test
	public void addUserTest(){
		User user=new User();
		user.setName("Test");
		user.setNumber("0000000000010");
		user.setImage("aasdjfhksjdhfkjasdhf");
		user.setIsVail("no");
		user.setPhone("12345678907");
		addUser(user);
	}

	*//*测试查询算法速度*//*
	@Test
	public void queryUserLuck(){
		queryLuck(50);
	}


	public void addUser(User user){
		long startTime=System.currentTimeMillis();
		String sql="INSERT into user(name,phone,number,image) VALUES (?,?,?,?)";
		Object []objects=new Object[]{user.getName(),user.getPhone(),user.getNumber(),user.getImage()};
		int result=0;
		for(int i=0;i<500;i++){
			result=jdbcTemplate.update(sql,objects);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("执行时间:"+(endTime-startTime));
	}

	public void queryLuck(int nubmer){
		long startTime=System.currentTimeMillis();
		Random random=new Random();
		String sql = "select * from user";
		//本次中奖用户列表
		List<User> users=new ArrayList<User>();
		//所有已经签到用户列表
		List<User> list=jdbcTemplate.query(sql,new MyRowMapper());
		for(int i=0;i<nubmer;i++){
			int index=random.nextInt(list.size());
			//增加中奖标识
			updateUser(list.get(index).getId());
			//用户添加入中奖用户列表
			users.add(list.get(index));
		}
		long endTime=System.currentTimeMillis();
		System.out.println("执行时间:"+(endTime-startTime));
	}

	//为用户添加已经中奖标识
	public void updateUser(int userId){
		long startTime=System.currentTimeMillis();
		Random random=new Random();
		String sql="update user set isValid=? where id = ?";
		//参数集
		Object o[]={"yes",userId};
		int result=jdbcTemplate.update(sql,o);
		long endTime=System.currentTimeMillis();
		System.out.println("标识方法执行时间:"+(endTime-startTime));
	}*/

}

