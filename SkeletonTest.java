import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkeletonTest {
Skeleton test;
@BeforeEach
	void setUp() throws Exception
	{
	 test= new Skeleton();
	}

	@Test
	void test() 
	{
	 Skeleton S1= new Skeleton();
	 assertEquals(3,S1.getAttackSpeed());
	 assertEquals(0.8,S1.getChanceToHit());
	 assertEquals(50,S1.getDamageMax());
	 assertEquals(30.0,S1.getDamageMin());
	 assertEquals(100,S1.getHitPoints());
	 assertEquals("Sargath the Skeleton",S1.getName());
	 
	}

}
