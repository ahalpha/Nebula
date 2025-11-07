package emu.nebula.server.handlers;

import emu.nebula.net.NetHandler;
import emu.nebula.net.NetMsgId;
import emu.nebula.proto.ScoreBossRank.ScoreBossRankInfo;
import emu.nebula.net.HandlerId;
import emu.nebula.Nebula;
import emu.nebula.net.GameSession;

@HandlerId(NetMsgId.score_boss_rank_req)
public class HandlerScoreBossRankReq extends NetHandler {

    @Override
    public byte[] handle(GameSession session, byte[] message) throws Exception {
        // Build response
        var rsp = ScoreBossRankInfo.newInstance()
                .setLastRefreshTime(Nebula.getCurrentTime());
        
        // Encode and send
        return session.encodeMsg(NetMsgId.score_boss_rank_succeed_ack, rsp);
    }

}
