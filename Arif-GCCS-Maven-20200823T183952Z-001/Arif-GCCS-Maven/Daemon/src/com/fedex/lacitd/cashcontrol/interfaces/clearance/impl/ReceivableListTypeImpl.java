//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.03 at 04:46:07 CLT 
//


package com.fedex.lacitd.cashcontrol.interfaces.clearance.impl;

public class ReceivableListTypeImpl implements com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableListType, com.sun.xml.bind.JAXBObject, com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallableObject, com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.XMLSerializable, com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.ValidatableObject
{

    protected com.sun.xml.bind.util.ListImpl _Receivable = new com.sun.xml.bind.util.ListImpl(new java.util.ArrayList());
    public final static java.lang.Class version = (com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableListType.class);
    }

    public java.util.List getReceivable() {
        return _Receivable;
    }

    public com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallingEventHandler createUnmarshaller(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallingContext context) {
        return new com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableListTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = _Receivable.size();
        while (idx1 != len1) {
            if (_Receivable.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsBody(((com.sun.xml.bind.JAXBObject) _Receivable.get(idx1 ++)), "Receivable");
            } else {
                context.startElement("", "receivable");
                int idx_0 = idx1;
                context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Receivable.get(idx_0 ++)), "Receivable");
                context.endNamespaceDecls();
                int idx_1 = idx1;
                context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Receivable.get(idx_1 ++)), "Receivable");
                context.endAttributes();
                context.childAsBody(((com.sun.xml.bind.JAXBObject) _Receivable.get(idx1 ++)), "Receivable");
                context.endElement();
            }
        }
    }

    public void serializeAttributes(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = _Receivable.size();
        while (idx1 != len1) {
            if (_Receivable.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Receivable.get(idx1 ++)), "Receivable");
            } else {
                idx1 += 1;
            }
        }
    }

    public void serializeURIs(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx1 = 0;
        final int len1 = _Receivable.size();
        while (idx1 != len1) {
            if (_Receivable.get(idx1) instanceof javax.xml.bind.Element) {
                context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Receivable.get(idx1 ++)), "Receivable");
            } else {
                idx1 += 1;
            }
        }
    }

    public java.lang.Class getPrimaryInterface() {
        return (com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableListType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001dcom.sun.msv.grammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun."
+"msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gramm"
+"ar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expression"
+"\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0003I\u0000\u000ecachedHashCodeL\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/l"
+"ang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0002xp\u0005\n\u0000Fppsr\u0000 com.sun.msv.gramm"
+"ar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0005\n\u0000;sr\u0000\u0011java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002"
+"\u0000\u0001Z\u0000\u0005valuexp\u0000psq\u0000~\u0000\u0000\u0005\n\u00008q\u0000~\u0000\npsr\u0000\'com.sun.msv.grammar.trex.E"
+"lementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/"
+"NameClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aig"
+"noreUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003\u0001\u00c5F\u008dq\u0000~\u0000\np"
+"\u0000sq\u0000~\u0000\u0000\u0001\u00c5F\u0082ppsq\u0000~\u0000\u0006\u0001\u00c5Fwq\u0000~\u0000\npsr\u0000 com.sun.msv.grammar.Attribu"
+"teExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\rxq\u0000~\u0000\u0003\u0001\u00c5Ftq\u0000~\u0000\np"
+"sr\u00002com.sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\bsq\u0000~\u0000\t\u0001psr\u0000 com.sun.msv.grammar.AnyNameClass\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000"
+"com.sun.msv.grammar.Expression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000x"
+"q\u0000~\u0000\u0003\u0000\u0000\u0000\tq\u0000~\u0000\u0016psr\u0000#com.sun.msv.grammar.SimpleNameClass\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNamet\u0000\u0012Ljava/lang/String;L\u0000\fnamespaceURIq\u0000~\u0000\u001dxq"
+"\u0000~\u0000\u0018t\u0000<com.fedex.lacitd.cashcontrol.interfaces.clearance.Rec"
+"eivablet\u0000+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000\f\u0003"
+"D\u00b9\u00a9q\u0000~\u0000\np\u0000sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~"
+"\u0000\u0001\u0003D\u00b9\u009eppsq\u0000~\u0000\f\u0001\u00c5F\u008dpp\u0000sq\u0000~\u0000\u0000\u0001\u00c5F\u0082ppsq\u0000~\u0000\u0006\u0001\u00c5Fwq\u0000~\u0000\npsq\u0000~\u0000\u0012\u0001\u00c5Ftq"
+"\u0000~\u0000\npq\u0000~\u0000\u0015q\u0000~\u0000\u0019q\u0000~\u0000\u001bsq\u0000~\u0000\u001ct\u0000@com.fedex.lacitd.cashcontrol.in"
+"terfaces.clearance.ReceivableTypeq\u0000~\u0000 sq\u0000~\u0000\u0000\u0001\u007fs\fppsq\u0000~\u0000\u0012\u0001\u007fs\u0001"
+"q\u0000~\u0000\npsr\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg"
+"/relaxng/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLcom/sun/"
+"msv/util/StringPair;xq\u0000~\u0000\u0003\u0000\u00f1\u008e\u009eppsr\u0000\"com.sun.msv.datatype.xsd"
+".QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000*com.sun.msv.datatype.xsd.BuiltinAto"
+"micType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0001\u0002\u0000\u0003L\u0000\fnamespaceUriq\u0000~\u0000\u001dL\u0000\btypeNameq\u0000~\u0000\u001dL\u0000\nwhiteSpacet\u0000.Lcom"
+"/sun/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u0000 http://www.w3"
+".org/2001/XMLSchemat\u0000\u0005QNamesr\u00005com.sun.msv.datatype.xsd.Whit"
+"eSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun.msv.datatype."
+"xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpsr\u00000com.sun.msv.grammar."
+"Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003\u0000\u0000\u0000\nppsr\u0000\u001bcom.s"
+"un.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u001dL\u0000\fnamespa"
+"ceURIq\u0000~\u0000\u001dxpq\u0000~\u00007q\u0000~\u00006sq\u0000~\u0000\u001ct\u0000\u0004typet\u0000)http://www.w3.org/2001"
+"/XMLSchema-instanceq\u0000~\u0000\u001bsq\u0000~\u0000\u001ct\u0000\nreceivablet\u0000\u0000q\u0000~\u0000\u001bsr\u0000\"com.s"
+"un.msv.grammar.ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/s"
+"un/msv/grammar/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.g"
+"rammar.ExpressionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0002\u0000\u0004I\u0000\u0005countI\u0000\tthresh"
+"oldL\u0000\u0006parentq\u0000~\u0000F[\u0000\u0005tablet\u0000![Lcom/sun/msv/grammar/Expression"
+";xp\u0000\u0000\u0000\t\u0000\u0000\u00009pur\u0000![Lcom.sun.msv.grammar.Expression;\u00d68D\u00c3]\u00ad\u00a7\n\u0002\u0000\u0000"
+"xp\u0000\u0000\u0000\u00bfq\u0000~\u0000&pppppppppq\u0000~\u0000\u0010q\u0000~\u0000%pppppppppppppppppppppppppppppp"
+"pppppppppppppppppppq\u0000~\u0000*pppppppppppppppppppppppppq\u0000~\u0000#pppppp"
+"pppppppppppppppppppppppppppq\u0000~\u0000\u000bppq\u0000~\u0000\bppppppppppq\u0000~\u0000\u0005pppppp"
+"ppppppppppppppppppppppppppppppppppppppppppppppppq\u0000~\u0000\u0011"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallingContext context) {
            super(context, "----");
        }

        protected Unmarshaller(com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableListTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().enterElement(___uri, ___local, ___qname, __atts);
                            return ;
                        }
                        if (("surcharges" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("surcharges" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("receiptNo" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("recPrepAmt" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("anchargeAmount" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("rodAmount" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("recAmount" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("exchRate" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("recCurrency" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("recNumber" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("recDate" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("customer" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("mtn" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("location" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname, __atts)));
                        return ;
                    case  0 :
                        if (("receivable" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableImpl.class), 1, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("receivable" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 2;
                            return ;
                        }
                        state = 1;
                        continue outer;
                    case  1 :
                        if (("receivable" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableImpl) spawnChildFromEnterElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableImpl.class), 1, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        if (("receivable" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 2;
                            return ;
                        }
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveElement(___uri, ___local, ___qname);
                            return ;
                        }
                        _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromLeaveElement((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname)));
                        return ;
                    case  0 :
                        state = 1;
                        continue outer;
                    case  3 :
                        if (("receivable" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 1;
                            return ;
                        }
                        break;
                    case  1 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        if (("num" == ___local)&&("" == ___uri)) {
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterAttribute((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname)));
                            return ;
                        }
                        _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromEnterAttribute((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname)));
                        return ;
                    case  0 :
                        state = 1;
                        continue outer;
                    case  1 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        attIdx = context.getAttribute("", "num");
                        if (attIdx >= 0) {
                            context.consumeAttribute(attIdx);
                            context.getCurrentHandler().leaveAttribute(___uri, ___local, ___qname);
                            return ;
                        }
                        _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromLeaveAttribute((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, ___uri, ___local, ___qname)));
                        return ;
                    case  0 :
                        state = 1;
                        continue outer;
                    case  1 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  2 :
                            attIdx = context.getAttribute("", "num");
                            if (attIdx >= 0) {
                                context.consumeAttribute(attIdx);
                                context.getCurrentHandler().text(value);
                                return ;
                            }
                            _Receivable.add(((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl) spawnChildFromText((com.fedex.lacitd.cashcontrol.interfaces.clearance.impl.ReceivableTypeImpl.class), 3, value)));
                            return ;
                        case  0 :
                            state = 1;
                            continue outer;
                        case  1 :
                            revertToParentFromText(value);
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}
