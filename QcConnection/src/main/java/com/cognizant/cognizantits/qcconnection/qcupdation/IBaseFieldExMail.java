package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{BF873A99-2FB9-43DB-9559-F9F0872F7534}")
public abstract interface IBaseFieldExMail
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract void mail(String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("0") int paramInt, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("") String paramString4);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseFieldExMail
 * JD-Core Version:    0.7.0.1
 */