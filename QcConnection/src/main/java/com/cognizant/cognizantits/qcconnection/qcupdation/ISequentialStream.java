package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.Holder;
import com4j.IID;
import com4j.VTID;

@IID("{0C733A30-2A1C-11CE-ADE5-00AA0044773D}")
public abstract interface ISequentialStream
  extends Com4jObject
{
  @VTID(3)
  public abstract void remoteRead(Holder<Byte> paramHolder, int paramInt, Holder<Integer> paramHolder1);
  
  @VTID(4)
  public abstract int remoteWrite(Holder<Byte> paramHolder, int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISequentialStream
 * JD-Core Version:    0.7.0.1
 */