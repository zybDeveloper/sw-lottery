package com.wozyb.lottery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


@SpringBootTest
public class LotteryApplicationTests {




	@Autowired
    JdbcTemplate jdbcTemplate;

	@Test
    public void checkLogin(){
        //jdbcTemplate.queryForList("select id,username,password from admin where username='?' and password='?'",obj);
        //List<Map<String,Object>> listmap=jdbcTemplate.queryForList("select id,username,password from admin where username='?' and password='?'",obj);
        List<Map<String,Object>> rows=jdbcTemplate.queryForList("select * from admin");
        for(int i =0;i<rows.size();i++){
            Map adminMap=rows.get(i);
            System.out.println(adminMap.get("id"));
            System.out.println(adminMap.get("username"));
            System.out.println(adminMap.get("password"));
        }

        /*if(listmap.size()>0){
            Map<String,Object> mo=listmap.get(0);
            for(Map.Entry<String,Object> m:mo.entrySet()){
                System.out.println("key="+m.getKey()+",value"+m.getValue());
            }
            System.out.println("true");
        }else{
            System.out.println("false");
        }*/
    }



/*
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

