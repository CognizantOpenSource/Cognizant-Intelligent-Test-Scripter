package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{BE138F24-989B-4E7B-9BE0-2484DC81F255}")
public abstract interface IAssignedLibraryPart
  extends Com4jObject
{
  @DISPID(14)
  @VTID(7)
  public abstract String assignedEntityId();
  
  @DISPID(14)
  @VTID(8)
  public abstract void assignedEntityId(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAssignedLibraryPart
 * JD-Core Version:    0.7.0.1
 */