package cl.enexo.test2kevin.data;

import java.util.ArrayList;
import java.util.List;

import cl.enexo.test2kevin.models.Match;

/**
 * Created by Kevin on 16-11-2016.
 */

public class MatchData {
    public List<Match> ObtainListMatch()
    {
        List<Match> maths = new ArrayList<>();
        //List<Match> matchList =null;
        List<Match> matchList = Match.find(Match.class,null);
        if (matchList != null && matchList.size() > 0)
        {
            maths.addAll(matchList);
        }
        return maths;
    }
}
