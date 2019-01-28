package com.horizen.secret;

import com.horizen.box.Box;
import com.horizen.proof.ProofOfKnowledge;
import com.horizen.proposition.ProofOfKnowledgeProposition;


interface SecretCompanion<S extends Secret, P extends ProofOfKnowledgeProposition<S>, PR extends ProofOfKnowledge<S,P>>
{
    // Its important to keep just Box as a parameter, because of logic in wallet
    boolean owns(S secret, Box box);

    PR sign(S secret, byte[] message);

    boolean verify(byte[] message, P publicImage, PR proof);

    // Secret always know about its public key, so no need to return tuple2<privatekey,publickey>
    S generateSecret(byte[] randomSeed);
    // TO DO: change to ...(NodeWallet wallet, byte[] seed);
}