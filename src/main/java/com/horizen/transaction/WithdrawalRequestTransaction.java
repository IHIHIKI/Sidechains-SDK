package com.horizen.transaction;

import com.horizen.NoncedBox;
import com.horizen.box.BoxUnlocker;
import com.horizen.proposition.Proposition;
import scala.util.Try;
import scorex.core.serialization.Serializer;

import java.util.ArrayList;
import java.util.HashMap;

public final class WithdrawalRequestTransaction extends NoncedBoxTransaction<Proposition, NoncedBox<Proposition>>
{
    @Override
    public WithdrawalRequestTransactionSerializer serializer() {
        return new WithdrawalRequestTransactionSerializer();
    }

    @Override
    public ArrayList<BoxUnlocker<Proposition>> unlockers() { return null; }

    // nothing to create
    @Override
    public ArrayList<NoncedBox<Proposition>> newBoxes() {
        return new ArrayList<NoncedBox<Proposition>>();
    }

    @Override
    public long fee() {
        return 0;
    }

    @Override
    public long timestamp() {
        return 0;
    }

    @Override
    public scorex.core.ModifierTypeId transactionTypeId() {
        return null; // scorex.core.ModifierTypeId @@ 3.toByte
    }
}


class WithdrawalRequestTransactionSerializer implements TransactionSerializer<WithdrawalRequestTransaction>
{
    private ListSerializer<NoncedBox<Proposition>> _boxSerializer;

    WithdrawalRequestTransactionSerializer() {
        HashMap<Integer, Serializer<NoncedBox<Proposition>>> supportedBoxSerializers = new HashMap<Integer, Serializer<NoncedBox<Proposition>>>();
        //supportedBoxSerializers.put(1, new RegularBoxSerializer());
        // TO DO: update supported serializers list

        _boxSerializer  = new ListSerializer<NoncedBox<Proposition>>(supportedBoxSerializers);
    }

    @Override
    public byte[] toBytes(WithdrawalRequestTransaction obj) {
        return _boxSerializer.toBytes(obj.newBoxes());
    }

    @Override
    public Try<WithdrawalRequestTransaction> parseBytes(byte[] bytes) {
        ArrayList<NoncedBox<Proposition>> boxes = _boxSerializer.parseBytes(bytes).get();
        return null;
    }
}