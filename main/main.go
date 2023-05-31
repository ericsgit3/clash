package main

import (
	"flag"
	"os"

	"github.com/xtls/xray-core/main/commands/base"
	_ "github.com/xtls/xray-core/main/distro/all"
)

func main() {
	os.Args = getArgsV4Compatible()

	base.RootCommand.Long = "Xray is a platform for building proxies."
	base.RootCommand.Commands = append(
		[]*base.Command{
			cmdRun,
			cmdVersion,
		},
		base.RootCommand.Commands...,
	)
	base.Execute()
}
