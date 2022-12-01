//package sc.junit;
//
//import static org.junit.Assert.*;
//
//import com.cn.BinaryOperation;
//import org.junit.Before;
//import org.junit.Test;
//
//public class BinaryOperationTest {
//	BinaryOperation bo;
//	@Before
//	public void setUp() throws Exception {
//		bo = new BinaryOperation() {
//			@Override
//			public boolean checkingCalculation(int anInteger) {
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
//	BinaryOperation bo2 = new BinaryOperation() {
//		@Override
//		protected boolean checkingCalculation(int anInteger) {
//			return false;
//		}
//
//		@Override
//		protected int calculate(int left, int right) {
//			return 0;
//		}
//
//		@Override
//		protected int calculate() {
//			return 0;
//		}
//	};
//	@Test
//	public void testNull(){
//		assertNull("不是空对象",bo2);
//	}
//	@Test
//	public void testEquals1(){
//		bo.construct(20, 30, '+');
//		bo2.construct(20, 30, '+');
//		assertSame("不是同一个对象",bo,bo2);
//	}
//	@Test
//	public void testEquals2(){
//		assertTrue("相等的对象",bo.equals(bo2));
//	}
//	@Test
//	public void testEquals3(){
//		bo2=bo;
//		assertSame("是同一个对象",bo,bo2);
//	}
//
//
//
//
//}
