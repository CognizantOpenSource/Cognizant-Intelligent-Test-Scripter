package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{682F76CF-D479-4A34-AD8F-108F6B6C23DB}")
public abstract interface IRunFactory
  extends IBaseFactory
{
  @DISPID(8)
  @VTID(16)
  public abstract String uniqueRunName();
  
  @DISPID(9)
  @VTID(17)
  public abstract void deleteDuplicateRuns(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IRunFactory
 * JD-Core Version:    0.7.0.1
 */