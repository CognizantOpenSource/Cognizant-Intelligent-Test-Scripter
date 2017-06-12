package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{EBB38286-D5A3-41DD-9EBA-F2791C10522F}")
public abstract interface ISupportCopyPaste
  extends Com4jObject
{
  @VTID(3)
  public abstract void pasteFromClipBoard(String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt1, @Optional @DefaultValue("-1") int paramInt2);
  
  @VTID(4)
  public abstract String copyToClipBoard(String paramString1, @Optional @DefaultValue("0") int paramInt, @Optional @DefaultValue("") String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportCopyPaste
 * JD-Core Version:    0.7.0.1
 */