package emu.nebula.server.handlers;

import emu.nebula.net.NetHandler;
import emu.nebula.net.NetMsgId;
import emu.nebula.net.HandlerId;
import emu.nebula.net.GameSession;

@HandlerId(NetMsgId.vampire_survivor_area_change_req)
public class HandlerVampireSurvivorAreaChangeReq extends NetHandler {

    @Override
    public byte[] handle(GameSession session, byte[] message) throws Exception {
        // Encode and send
        return session.encodeMsg(NetMsgId.vampire_survivor_area_change_succeed_ack);
    }

}
