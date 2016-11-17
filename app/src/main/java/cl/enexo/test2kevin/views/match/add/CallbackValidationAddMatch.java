package cl.enexo.test2kevin.views.match.add;

import cl.enexo.test2kevin.models.Match;

/**
 * Created by Kevin on 16-11-2016.
 */

public interface CallbackValidationAddMatch {
    void ok(Match match);
    void fail();
}
