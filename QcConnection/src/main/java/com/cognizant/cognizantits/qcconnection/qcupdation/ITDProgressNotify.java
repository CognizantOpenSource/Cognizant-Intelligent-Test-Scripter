package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.VTID;

@IID("{B3391F80-3861-11D3-AFAB-00600855298D}")
public abstract interface ITDProgressNotify
  extends Com4jObject
{
  @VTID(3)
  public abstract void onProgress(int paramInt1, int paramInt2, String paramString);
  
  @VTID(4)
  public abstract void onDataAvailable(int paramInt);
  
  @VTID(5)
  public abstract void onServerProgress(int paramInt, String paramString);
  
  @VTID(6)
  public abstract void onMessage(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDProgressNotify
 * JD-Core Version:    0.7.0.1
 */