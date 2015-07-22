package redstonelamp.network.packet;

import redstonelamp.network.NetworkInfo;
import redstonelamp.utils.DynamicByteBuffer;

/**
 * FullChunkDataPacket (0xaf)
 */
public class FullChunkDataPacket extends DataPacket{
    public final static byte ID = NetworkInfo.FULL_CHUNK_DATA_PACKET;

    public int x;
    public int z;
    public byte[] payload;

    @Override
    public byte getPID() {
        return NetworkInfo.FULL_CHUNK_DATA_PACKET;
    }

    @Override
    protected void _encode(DynamicByteBuffer bb) {
        bb.putInt(x);
        bb.putInt(z);
        bb.putInt(payload.length);
        bb.put(payload);
    }

    @Override
    protected void _decode(DynamicByteBuffer bb) {

    }
}
