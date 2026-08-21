package com.cast.ACA.code_samples;

import com.cast.monster_event.base.dao.MonsterDao;
import com.cast.monster_event.base.dao.SpookyOptionDao;
import com.cast.monster_event.base.dao.SpookyPlaceDao;

public class Access_DF
{
	@SuppressWarnings("unused")
	public static int findAllMonsters()
	{
		if (false) // Avoids crash when tests application is really run
			new MonsterDao().findAllMonsters();

		return 0;
	}
	
	@SuppressWarnings("unused")
	public static int accessSpookyOption()
	{
		if (false) // Avoids crash when tests application is really run
			new SpookyOptionDao().findAllSpookyOptions();

		return 0;
	}
	
	@SuppressWarnings("unused")
	public static int accessSpookyPlace()
	{
		if (false) // Avoids crash when tests application is really run
			new SpookyPlaceDao().findAllSpookyPlaces();

		return 0;
	}
}
