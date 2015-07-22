package redstonelamp.network.packet;

import redstonelamp.network.NetworkInfo;
import redstonelamp.utils.DynamicByteBuffer;

/**
 * SetTimePacket (0x86)
 */
public class SetTimePacket extends DataPacket{
    public final static byte ID = NetworkInfo.SET_TIME_PACKET;

    public int time;
    public boolean started = true;

    @Override
    public byte getPID() {
        return NetworkInfo.SET_TIME_PACKET;
    }

    @Override
    protected void _encode(DynamicByteBuffer bb) {
        bb.putInt(time);
        bb.putByte((byte) (started ? 0x80 : 0x00));
    }

    @Override
    protected void _decode(DynamicByteBuffer bb) {

    }
}
