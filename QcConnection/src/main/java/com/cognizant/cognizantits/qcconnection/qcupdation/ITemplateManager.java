package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{BA6B81E9-5244-476B-AE23-FBA6980356F9}")
public abstract interface ITemplateManager
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList linkedProjects();
  
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object linkedProjects(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract int analyzePolicy(String paramString1, String paramString2);
  
  @DISPID(3)
  @VTID(9)
  public abstract int enforcePolicy(String paramString1, String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITemplateManager
 * JD-Core Version:    0.7.0.1
 */