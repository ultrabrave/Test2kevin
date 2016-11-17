package cl.enexo.test2kevin.views.match.add;

import java.util.Date;

import cl.enexo.test2kevin.models.Match;
import cl.enexo.test2kevin.views.match.add.CallbackValidationAddMatch;

/**
 * Created by Kevin on 16-11-2016.
 */

public class AddMatchValidation {
    private CallbackValidationAddMatch callback;

    public AddMatchValidation(CallbackValidationAddMatch callback) {
        this.callback = callback;
    }

    public void newMatch(String name,String place,int time)
    {
        if (name.trim().length()>0 && place.trim().length()>0 && time > 0)
        {
            Match match = new Match();
            match.setName(name);
            match.setDatematch(new Date());
            match.setPlace(place);
            match.setTime(String.valueOf(time));
            match.save();
            callback.ok(match);
        }
        else
        {
            callback.fail();
        }
    }
}
