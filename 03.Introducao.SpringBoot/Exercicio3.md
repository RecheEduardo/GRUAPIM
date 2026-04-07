## Qual a principal diferença entre REST e SOAP?

A principal diferença entre REST e SOAP está na natureza de cada abordagem. REST é um estilo arquitetural baseado em princípios simples da web, utilizando recursos identificados por URLs e os métodos HTTP padrão, como GET, POST, PUT e DELETE. Já SOAP é um protocolo formal e rígido, que define um conjunto de regras para troca de mensagens estruturadas em XML. Enquanto REST prioriza simplicidade, flexibilidade e desempenho, SOAP enfatiza padronização, contrato formal (WSDL) e extensibilidade, sendo mais verboso e complexo.

---

## Em quais cenários SOAP ainda é amplamente utilizado?

SOAP ainda é amplamente utilizado em cenários corporativos que exigem alto nível de segurança, confiabilidade e integridade nas transações. Isso inclui sistemas bancários, aplicações de saúde, integrações governamentais e ambientes empresariais com forte presença de sistemas legados. Nesses contextos, recursos como transações distribuídas, garantias de entrega de mensagens e padrões avançados de segurança tornam o SOAP mais adequado, especialmente em integrações B2B onde contratos formais e estabilidade são essenciais.

---

## Quais são as vantagens e desvantagens de usar REST ao invés de SOAP?

O uso de REST traz como principais vantagens a simplicidade de implementação, menor consumo de recursos e melhor desempenho, já que normalmente utiliza JSON em vez de XML. Além disso, REST é mais fácil de consumir, especialmente em aplicações web e mobile, e se integra naturalmente com a arquitetura da internet. Por outro lado, REST não possui padrões nativos tão robustos quanto SOAP para segurança, transações e confiabilidade. Isso significa que muitas dessas funcionalidades precisam ser implementadas manualmente ou com o auxílio de outras ferramentas, o que pode aumentar a complexidade em sistemas mais críticos.

---

## O que é WS-Security e como ele se compara à segurança em APIs REST?

WS-Security é um conjunto de especificações utilizadas em serviços SOAP para garantir a segurança das mensagens trocadas, incluindo autenticação, integridade e confidencialidade. Ele permite, por exemplo, a assinatura digital e a criptografia de partes específicas da mensagem XML, além de suportar tokens de segurança sofisticados. Em comparação, a segurança em APIs REST geralmente é mais simples e baseada em mecanismos como HTTPS, autenticação via tokens (como JWT) e OAuth. Embora eficaz, essa abordagem não possui um padrão único tão abrangente quanto o WS-Security, sendo mais flexível, porém menos padronizada.

---

## Explique o modelo de maturidade de Richardson e em que nível SOAP se encaixa

O modelo de maturidade de Richardson é uma forma de classificar o nível de aderência de uma API aos princípios REST. Ele é dividido em quatro níveis. O nível 0 representa o uso de HTTP apenas como transporte, sem exploração de seus recursos. O nível 1 introduz o conceito de recursos, organizando melhor os endpoints. O nível 2 utiliza corretamente os verbos HTTP, como GET e POST, alinhando-se ao comportamento esperado da web. Já o nível 3 adiciona o uso de hipermídia (HATEOAS), permitindo que a API seja navegável dinamicamente por meio de links.

O SOAP se encaixa no nível 0 desse modelo, pois utiliza HTTP apenas como meio de transporte para mensagens XML, sem aproveitar os conceitos fundamentais da arquitetura REST, como recursos e verbos HTTP.
