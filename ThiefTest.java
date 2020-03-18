import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThiefTest 
{
 Thief test;
	@BeforeEach
	void setUp() throws Exception
	{
		test = new Thief();
	}

	@Test
	public void test()
	{
		Thief T1= new Thief();
		assertEquals(12,T1.getAttackSpeed());
		assertEquals(0.1,T1.getChanceTobBlock());
		assertEquals(69.2,T1.getChanceToHit());
		assertEquals("Thief",T1.getClass());
		assertEquals(12,T1.getDamageMax());
		assertEquals(1,T1.getDamageMin());
		assertEquals(23,T1.getHitPoints());
		assertEquals("bob",T1.getName());
		assertEquals(3,T1.getNumTurns());	
	}

}
