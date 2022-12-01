//package sc.junit;
//
//import static org.junit.Assert.*;
//import com.cn.BinaryOperation;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
//
//import java.util.Arrays;
//import java.util.Collection;
//
////参数测试运行器,必须放在测试类的前面
//@RunWith(Parameterized.class)
//public class BinaryOperationGroupTest {
//	private int expect,operand1,operand2;
//	private char operator;
//	BinaryOperation bo;
//
//	@Before
//	public void setUp() throws Exception {
//		bo = new BinaryOperation() {
//			@Override
//			protected boolean checkingCalculation(int anInteger) {
//				return false;
//			}
//
//			@Override
//			protected int calculate(int left, int right) {
//				return 0;
//			}
//
//			@Override
//			protected int calculate() {
//				return 0;
//			}
//		};
//	}
//	// 存放一组测试数据
//	@Parameters
//	public static Collection<Object[]> data(){
//		return Arrays.asList(new Object[][]{
//		{0,100,'+',100},
//		{99,1,'+',100},
//		{100,1,'-',99},
//		{100,0,'-',99},
//		/*{99,1,'+',98},
//		{110,2,'+',55},
//		{10,29,'-',10},
//		{10,9,'$',10},*/
//		});
//	}
//	// 测试类构造器
//	public BinaryOperationGroupTest(int left, int right, char op, int exp){
//		expect=exp;
//		operand1=left;
//		operand2=right;
//		operator = op;
//	}
//	// 对一组测试数据循环执行测试
//	@Test
//	public void groupTets(){
//		int result = bo.construct(operand1,operand2,operator);
//		assertEquals(expect,result);
//	}
//
//}
