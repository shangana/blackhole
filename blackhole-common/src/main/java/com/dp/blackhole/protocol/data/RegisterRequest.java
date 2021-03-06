package com.dp.blackhole.protocol.data;

import java.nio.ByteBuffer;

import com.dp.blackhole.network.GenUtil;
import com.dp.blackhole.network.NonDelegationTypedWrappable;

public class RegisterRequest extends NonDelegationTypedWrappable {
    public String topic;
    public String partitionId;
    public long period;
    public String broker;
    
    public RegisterRequest() {
    }
    
    public RegisterRequest(String topic, String partitionId, long period, String broker) {
        this.topic = topic;
        this.partitionId = partitionId;
        this.period = period;
        this.broker = broker;
    }
    
    @Override
    public int getSize() {
        return GenUtil.getStringSize(topic) + GenUtil.getStringSize(partitionId) + Long.SIZE/8 + GenUtil.getStringSize(broker);
    }

    @Override
    public void read(ByteBuffer buffer) {
        topic = GenUtil.readString(buffer);
        partitionId = GenUtil.readString(buffer);
        period = buffer.getLong();
        broker = GenUtil.readString(buffer);
    }

    @Override
    public void write(ByteBuffer buffer) {
        GenUtil.writeString(topic, buffer);
        GenUtil.writeString(partitionId, buffer);
        buffer.putLong(period);
        GenUtil.writeString(broker, buffer);
    }

    @Override
    public int getType() {
        return DataMessageTypeFactory.RegisterRequest;
    }
}
