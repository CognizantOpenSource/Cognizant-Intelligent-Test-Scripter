package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{137CC633-E0CF-4DED-B738-12D5B39C42CB}")
public abstract interface IResourceStorage
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void uploadResource(String paramString, boolean paramBoolean);
  
  @DISPID(2)
  @VTID(8)
  public abstract String downloadResource(String paramString, boolean paramBoolean);
  
  @DISPID(3)
  @VTID(9)
  public abstract void clean();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IResourceStorage
 * JD-Core Version:    0.7.0.1
 */