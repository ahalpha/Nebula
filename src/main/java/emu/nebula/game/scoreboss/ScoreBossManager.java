package emu.nebula.game.scoreboss;

import emu.nebula.data.GameData;
import emu.nebula.data.resources.ScoreBossControlDef;
import emu.nebula.game.player.Player;
import emu.nebula.game.player.PlayerManager;
import lombok.Getter;

@Getter
public class ScoreBossManager extends PlayerManager  {
    private int levelId;
    private long buildId;
    
    public ScoreBossManager(Player player) {
        super(player);
    }
    
    public int getControlId() {
        return 1;
    }
    
    public ScoreBossControlDef getControlData() {
        return GameData.getScoreBossControlDataTable().get(this.getControlId());
    }
    
    public boolean apply(int levelId, long buildId) {
        // Get level
        var control = getControlData();
        if (control == null || !control.getLevelGroup().contains(levelId)) {
            return false;
        }
        
        // Get build
        var build = this.getPlayer().getStarTowerManager().getBuildById(buildId);
        if (build == null) {
            return false;
        }
        
        // Set
        this.levelId = levelId;
        this.buildId = buildId;
        
        // Success
        return true;
    }

    public void settle(int star, int score) {
        // TODO
    }
}
