package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.IID;
import com4j.VTID;

@IID("{0000000C-0000-0000-C000-000000000046}")
public abstract interface IStream
  extends ISequentialStream
{
  @VTID(8)
  public abstract void commit(int paramInt);
  
  @VTID(9)
  public abstract void revert();
  
  @VTID(13)
  public abstract IStream clone();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IStream
 * JD-Core Version:    0.7.0.1
 */