package com.dp.blackhole.collectornode.persistent;

import java.io.IOException;
import java.nio.channels.GatheringByteChannel;

public interface MessageSet {

    public long write(GatheringByteChannel channel, int offset, int length) throws IOException; 

    public int getSize();
}
