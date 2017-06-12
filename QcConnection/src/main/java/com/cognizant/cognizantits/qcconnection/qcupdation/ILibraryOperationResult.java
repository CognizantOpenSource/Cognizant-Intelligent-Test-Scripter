package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{84F0815E-B133-4F16-BDEB-952BA7C6E41F}")
public abstract interface ILibraryOperationResult
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String resultString();
  
  @DISPID(2)
  @VTID(8)
  public abstract String filesList();
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean isPassed();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILibraryOperationResult
 * JD-Core Version:    0.7.0.1
 */