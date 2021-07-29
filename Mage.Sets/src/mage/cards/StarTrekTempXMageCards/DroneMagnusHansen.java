package mage.cards.d;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.dynamicvalue.common.DevotionCount;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.keyword.DevoidAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.SubType;
import mage.game.Game;
import mage.players.Player;

import java.util.Objects;
import java.util.UUID;

/**
 * @author amcomeau
 */
public final class DroneMagnusHansen extends CardImpl {

    public DroneMagnusHansen(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{3}{B}{B}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.BORG);
        this.subtype.add(SubType.DRONE);

        this.power = new MageInt(2);
        this.toughness = new MageInt(4);

        // When Drone Magnus Hansen enters the battlefield, each opponent loses X life, where X is your devotion to black. You gain life equal to the life lost this way.
        this.addAbility(new EntersBattlefieldTriggeredAbility(
                new DroneMagnusHansenEffect(), false
        ).addHint(DevotionCount.B.getHint()));
    }

    private DroneMagnusHansen(final DroneMagnusHansen card) {
        super(card);
    }

    @Override
    public DroneMagnusHansen copy() {
        return new DroneMagnusHansen(this);
    }
}

class DroneMagnusHansenEffect extends OneShotEffect {

    DroneMagnusHansenEffect() {
        super(Outcome.GainLife);
        this.staticText = "each opponent loses X life, where X is your devotion to black. "
                + "You gain life equal to the life lost this way. "
                + "<i>(Each {B} in the mana costs of permanents you control "
                + "counts towards your devotion to black.)</i>";
    }

    private DroneMagnusHansenEffect(final DroneMagnusHansenEffect effect) {
        super(effect);
    }

    @Override
    public DroneMagnusHansenEffect copy() {
        return new DroneMagnusHansenEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        if (controller == null) {
            return false;
        }
        int lifeLost = DevotionCount.B.calculate(game, source, this);
        if (lifeLost == 0) {
            return true;
        }
        int totalLifeLost = game
                .getOpponents(source.getControllerId())
                .stream()
                .map(game::getPlayer)
                .filter(Objects::nonNull)
                .mapToInt(opponent -> opponent.loseLife(lifeLost, game, source, false))
                .sum();
        return controller.gainLife(totalLifeLost, game, source) > 0;
    }
}
