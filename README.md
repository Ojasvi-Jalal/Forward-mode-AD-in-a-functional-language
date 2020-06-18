# Forward-mode-AD-in-a-functional-language

The project constitutes my honours thesis at the School of Informatics, University of Edinburgh, Scotland. 

Inspired by F smooth (https://arxiv.org/pdf/1806.02136.pdf), it delivers a system called ddx in a functional framework. ddx is capable of performing both forward mode AD and symbolic differentiation. Unlike  F smooth, ddx only has a simple interpreter and does not implement reverse mode AD. However, ddx's simple implementation ensures that these features can be introduced with much ease in the near future. 

The correctness and efficiency of ddx are demonstrated using several benchmarks. The results obtained from these benchmarks support the argument that AD is more efficient than its counterpart symbolic differentiation. Please refer to the thesis document for further details. 
