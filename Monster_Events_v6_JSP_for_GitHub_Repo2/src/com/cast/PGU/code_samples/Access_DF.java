package com.cast.PGU.code_samples;

import com.cast.monster_event.base.dao.MonsterDao;

public class Access_DF
{
	public static int findAllMonsters()
	{
		if (false) // Avoids crash when tests application is really run
			new MonsterDao().findAllMonsters();

		return 0;
	}
}
