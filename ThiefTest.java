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
		assertEquals(6,T1.getAttackSpeed());
		assertEquals(0.5,T1.getChanceTobBlock());
		assertEquals(0.8,T1.getChanceToHit());
		assertEquals(40,T1.getDamageMax());
		assertEquals(20,T1.getDamageMin());
		assertEquals(75,T1.getHitPoints());
		assertEquals("bob",T1.getName());
		assertEquals(0,T1.getNumTurns());	
	}

}
