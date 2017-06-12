package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{A54D914D-3CCB-49FC-B07B-0B496FBF0CC3}")
public abstract interface IVCS2
  extends IVCS
{
  @DISPID(21)
  @VTID(27)
  public abstract void checkInAndOverrideLastVersion(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IVCS2
 * JD-Core Version:    0.7.0.1
 */