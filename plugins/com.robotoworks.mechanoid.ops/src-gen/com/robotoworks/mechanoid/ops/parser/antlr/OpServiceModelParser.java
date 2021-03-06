/*
* generated by Xtext
*/
package com.robotoworks.mechanoid.ops.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import com.robotoworks.mechanoid.ops.services.OpServiceModelGrammarAccess;

public class OpServiceModelParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private OpServiceModelGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected com.robotoworks.mechanoid.ops.parser.antlr.internal.InternalOpServiceModelParser createParser(XtextTokenStream stream) {
		return new com.robotoworks.mechanoid.ops.parser.antlr.internal.InternalOpServiceModelParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}
	
	public OpServiceModelGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(OpServiceModelGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
