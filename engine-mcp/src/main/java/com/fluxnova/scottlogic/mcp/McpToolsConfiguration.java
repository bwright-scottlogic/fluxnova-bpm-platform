package com.fluxnova.scottlogic.mcp;

import com.fluxnova.scottlogic.mcp.tools.AuthorizationTools;
import com.fluxnova.scottlogic.mcp.tools.DecisionTools;
import com.fluxnova.scottlogic.mcp.tools.ExternalTaskTools;
import com.fluxnova.scottlogic.mcp.tools.FormTools;
import com.fluxnova.scottlogic.mcp.tools.HistoryTools;
import com.fluxnova.scottlogic.mcp.tools.IdentityTools;
import com.fluxnova.scottlogic.mcp.tools.ManagementTools;
import com.fluxnova.scottlogic.mcp.tools.ProcessInstanceTools;
import com.fluxnova.scottlogic.mcp.tools.RepositoryTools;
import com.fluxnova.scottlogic.mcp.tools.SignalTools;
import com.fluxnova.scottlogic.mcp.tools.TaskTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpToolsConfiguration {

    /**
     * Registers all BPM tool objects with Spring AI's MCP server.
     * The MCP auto-configuration discovers this bean and exposes every
     * {@code @Tool}-annotated method as an MCP tool.
     */
    @Bean
    public ToolCallbackProvider bpmToolCallbackProvider(
            ProcessInstanceTools processInstanceTools,
            TaskTools taskTools,
            RepositoryTools repositoryTools,
            HistoryTools historyTools,
            SignalTools signalTools,
            ExternalTaskTools externalTaskTools,
            IdentityTools identityTools,
            ManagementTools managementTools,
            FormTools formTools,
            DecisionTools decisionTools,
            AuthorizationTools authorizationTools) {

        return MethodToolCallbackProvider.builder()
                .toolObjects(
                        processInstanceTools,
                        taskTools,
                        repositoryTools,
                        historyTools,
                        signalTools,
                        externalTaskTools,
                        identityTools,
                        managementTools,
                        formTools,
                        decisionTools,
                        authorizationTools)
                .build();
    }
}
